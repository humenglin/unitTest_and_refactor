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
import com.coding.sales.interfaces.impl.CardCreateFactory;
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

	public static void main(String[] args) {
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

	public String checkout(String orderCommand) {
		OrderCommand command = OrderCommand.from(orderCommand);
		OrderRepresentation result = checkout(command);

		return result.toString();
	}

	OrderRepresentation checkout(OrderCommand command) {
		OrderRepresentation result = null;

		String orderId = command.getOrderId();
		Date createTime = formatDate(command.getCreateTime());

		Map<String, Member> members = Members.getMembers();
		String memberNo = command.getMemberId();
		Member member = members.get(memberNo);
		String memberName = member.getMemberName();
		String oldMemberType = member.getMemberType();

		// 积分计算规则
		int memberPointsIncreased = 9860;
		int memberPoints = 19720;
		CardCreateFactory cardCreateFactory = new CardCreateFactory();
		
		CardInfo cardInfo = cardCreateFactory.createCard(memberPoints);
		String newMemberType = cardInfo.getMemberType();
		
		List<OrderItemRepresentation> orderItems = generateOrderItemRepresentation(command.getItems());
		BigDecimal totalPrice = new BigDecimal("10624.00");
		List<DiscountItemRepresentation> discounts = generateDiscountItemRepresentation();
		BigDecimal totalDiscountPrice = new BigDecimal("764.00");
		BigDecimal receivables = new BigDecimal("9860.00");
		List<PaymentRepresentation> payments = generatePaymentRepresentation();
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

	private List<PaymentRepresentation> generatePaymentRepresentation() {
		List<PaymentRepresentation> payments = new ArrayList<PaymentRepresentation>();
		PaymentRepresentation payment = new PaymentRepresentation("余额支付", new BigDecimal("9860.00"));
		payments.add(payment);
		return payments;
	}

	//处理规则
	private List<DiscountItemRepresentation> generateDiscountItemRepresentation() {
		List<DiscountItemRepresentation> discounts = new ArrayList<DiscountItemRepresentation>();

		DiscountItemRepresentation discount1 = new DiscountItemRepresentation("001002", "2019北京世园会纪念银章大全40g",
				new BigDecimal("414.00"));
		DiscountItemRepresentation discount2 = new DiscountItemRepresentation("002003", "中国银象棋12g",
				new BigDecimal("350.00"));
		discounts.add(discount1);
		discounts.add(discount2);
		return discounts;
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
}
