package com.coding.sales;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.coding.sales.init.Members;
import com.coding.sales.init.PreciousMetals;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.interfaces.ActivityRuleInteface;
import com.coding.sales.interfaces.CardInfoInteface;
import com.coding.sales.interfaces.VoucherRuleInteface;
import com.coding.sales.interfaces.impl.ActivityRuleImpl;
import com.coding.sales.interfaces.impl.CardCreateFactory;
import com.coding.sales.interfaces.impl.VoucherRuleImpl;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;
import com.coding.sales.pojo.CardInfo;
import com.coding.sales.pojo.Member;
import com.coding.sales.pojo.PreciousMetal;

/**
 * 销售系统的主入口 用于打印销售凭证
 */
public class OrderApp {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
		}
		// 准备参数
		String jsonFileName = args[0];
		String txtFileName = args[1];

		String orderCommand = FileUtils.readFromFile(jsonFileName);
		OrderApp app = new OrderApp();
		String result = app.checkout(orderCommand);
		FileUtils.writeToFile(result, txtFileName);
	}

	public String checkout(String orderCommand) throws Exception {
		OrderCommand command = OrderCommand.from(orderCommand);
		OrderRepresentation result = checkout(command);

		return result.toString();
	}

	OrderRepresentation checkout(OrderCommand command) throws Exception {
		OrderRepresentation result = null;

		String orderId = command.getOrderId();
		Date createTime = formatDate(command.getCreateTime());

		Map<String, Member> members = Members.getMembers();
		String memberNo = command.getMemberId();
		Member member = members.get(memberNo);
		String memberName = member.getMemberName();

		CardInfo memberCardInfo = member.getCardInfo();
		String oldMemberType = memberCardInfo.getMemberType();

		// 积分计算规则
		int memberPointsIncreased = command.getPayments().get(0).getAmount().intValue();
		int memberPoints = member.getMemberPoints()
				+ memberPointsIncreased * memberCardInfo.getPointMutiple().intValue();

		//根据不同积分返回不同卡种
		CardInfoInteface cardInfoInteface = new CardCreateFactory();
		CardInfo memberCardInfoNew = cardInfoInteface.createCard(memberPoints);
		String newMemberType = memberCardInfoNew.getMemberType();
		member.setCardInfo(memberCardInfoNew);

		List<OrderItemRepresentation> orderItems = generateOrderItemRepresentation(command.getItems());
		BigDecimal totalPrice = totalAmount(orderItems);

		List<DiscountItemRepresentation> discounts = computeAmount(command.getItems(), command.getPayments(),
				command.getDiscounts());
		BigDecimal totalDiscountPrice = discountTotalAmount(discounts);
		BigDecimal receivables = command.getPayments().get(0).getAmount();
		
		List<PaymentRepresentation> payments = generatePaymentRepresentation(command.getPayments());
		List<String> discountCards = command.getDiscounts();

		result = new OrderRepresentation(orderId, createTime, memberNo, memberName, oldMemberType, newMemberType,
				memberPointsIncreased, memberPoints, orderItems, totalPrice, discounts, totalDiscountPrice, receivables,
				payments, discountCards);

		return result;
	}

	private Date formatDate(String time) {
		Date createTime = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			createTime = dateFormat.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createTime;
	}

	private List<PaymentRepresentation> generatePaymentRepresentation(List<PaymentCommand> list) {
		List<PaymentRepresentation> payments = new ArrayList<PaymentRepresentation>();
		for (PaymentCommand paymentCommand: list) {
			PaymentRepresentation payment = new PaymentRepresentation(paymentCommand.getType(), paymentCommand.getAmount());
			payments.add(payment);
		}
		return payments;
	}


	private List<OrderItemRepresentation> generateOrderItemRepresentation(List<OrderItemCommand> items) {

		List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();

		for (OrderItemCommand orderItemCommand : items) {
			PreciousMetal preciousMetals = PreciousMetals.getPreciousMetals().get(orderItemCommand.getProduct());
			String productName = preciousMetals.getProductName();
			BigDecimal onePrice = preciousMetals.getPrice();
			BigDecimal allPrice = onePrice.multiply(orderItemCommand.getAmount());

			OrderItemRepresentation orderItem = new OrderItemRepresentation(orderItemCommand.getProduct(), productName,
					onePrice, orderItemCommand.getAmount(), allPrice);
			orderItems.add(orderItem);
		}

		return orderItems;
	}

	/**
	 * 计算总金额
	 * 
	 * @param list
	 * @return
	 */
	private BigDecimal totalAmount(List<OrderItemRepresentation> list) {
		BigDecimal totalAmount = BigDecimal.ZERO;
		for (OrderItemRepresentation orderItemRepresentation : list) {
			totalAmount = orderItemRepresentation.getSubTotal().add(totalAmount);
		}
		return totalAmount;
	}

	// 计算活动金额
	private List<DiscountItemRepresentation> computeAmount(List<OrderItemCommand> items, List<PaymentCommand> payments,
			List<String> discounts) throws Exception {

		List<DiscountItemRepresentation> DiscountItemRepresentationList = new ArrayList<DiscountItemRepresentation>();

		for (OrderItemCommand orderItemCommand : items) {
			PreciousMetal preciousMetal = PreciousMetals.getPreciousMetals().get(orderItemCommand.getProduct());
			// 获取当前商品的单价
			BigDecimal price = preciousMetal.getPrice();
			// 获取活动类型
			List<String> activityList = preciousMetal.getActicity();
			// 代金券
			String voucher = preciousMetal.getVoucher();
			// 当前商品的数量
			BigDecimal goodsAmount = orderItemCommand.getAmount();
			// 计算该商品的总价
			BigDecimal goodsTotalAmount = orderItemCommand.getAmount().multiply(price);
			// 如果这个商品有活动
			BigDecimal discountOfactivity = BigDecimal.ZERO;
			ActivityRuleInteface activityRule = new ActivityRuleImpl();
			if (!activityList.isEmpty()) {
				// 计算商品折扣价
				for (String activityType : activityList) {
					discountOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
				}

			}
			// 如果代金券不为空
			BigDecimal discount = BigDecimal.ZERO;
			VoucherRuleInteface voucherRule = new VoucherRuleImpl();
			if (!discounts.isEmpty() && voucher != null) {
				for (String discountVor : discounts) {
					discount=voucherRule.voucherRule(voucher, discountVor, discount, goodsTotalAmount);
				}
			}
			if (discountOfactivity.compareTo(discount) == -1) {
				discountOfactivity = discount;
			}
			if (discountOfactivity.compareTo(BigDecimal.ZERO) == 1) {
				DiscountItemRepresentation discount1 = new DiscountItemRepresentation(orderItemCommand.getProduct(),
						PreciousMetals.getPreciousMetals().get(orderItemCommand.getProduct()).getProductName(),
						discountOfactivity);
				DiscountItemRepresentationList.add(discount1);
			}
		}
		return DiscountItemRepresentationList;
	}
	
	private BigDecimal discountTotalAmount ( List<DiscountItemRepresentation> list){
		BigDecimal discountTotalAmount = BigDecimal.ZERO;
		for (DiscountItemRepresentation discountItemRepresentation : list) {
			discountTotalAmount = discountItemRepresentation.getDiscount().add(discountTotalAmount);
		}
		return discountTotalAmount;
		
		
		
	}
}
