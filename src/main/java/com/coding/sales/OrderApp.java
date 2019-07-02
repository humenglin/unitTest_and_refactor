package com.coding.sales;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coding.sales.input.OrderCommand;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;

/**
 * 销售系统的主入口 用于打印销售凭证
 */
public class OrderApp {

	public static void main(String[] args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
		}

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date createTime = null;
        try {
			createTime = dateFormat.parse(command.getCreateTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        String memberNo = command.getMemberId();
        String memberName = "马丁";
        String oldMemberType = "普卡";
        String newMemberType = "金卡";
        int memberPointsIncreased = 9860;
        int memberPoints = 19720;
        List<OrderItemRepresentation> orderItems = generateOrderItemRepresentation();
        BigDecimal totalPrice = new BigDecimal("10624.00");
        List<DiscountItemRepresentation> discounts = generateDiscountItemRepresentation();
        BigDecimal totalDiscountPrice = new BigDecimal("764.00");
        BigDecimal receivables = new BigDecimal("9860.00");
        List<PaymentRepresentation> payments = generatePaymentRepresentation();
        List<String> discountCards = generateDiscountCards();
        
        result = new OrderRepresentation(orderId, createTime, memberNo, memberName, oldMemberType, newMemberType, memberPointsIncreased, memberPoints,
                 orderItems, totalPrice, discounts, totalDiscountPrice, receivables, payments, discountCards);

        return result;
    }

	private List<String> generateDiscountCards() {
		List<String> discountCards = new ArrayList<String>();
		discountCards.add("9折券");
		return discountCards;
	}

	private List<PaymentRepresentation> generatePaymentRepresentation() {
		List<PaymentRepresentation> payments = new ArrayList<PaymentRepresentation>();
		PaymentRepresentation payment = new PaymentRepresentation("余额支付", new BigDecimal("9860.00"));
		payments.add(payment);
		return payments;
	}

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

	private List<OrderItemRepresentation> generateOrderItemRepresentation() {
		List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation> ();
		OrderItemRepresentation orderItem1 = new OrderItemRepresentation("001001", "世园会五十国钱币册", new BigDecimal("998.00"), new BigDecimal("2"), new BigDecimal(("1996.00")));
		OrderItemRepresentation orderItem2 = new OrderItemRepresentation("001002", "2019北京世园会纪念银章大全40g", new BigDecimal("1380.00"), new BigDecimal("3"), new BigDecimal(("4140.00")));
		OrderItemRepresentation orderItem3 = new OrderItemRepresentation("002002", "中国经典钱币套装", new BigDecimal("998.00"), new BigDecimal("1"), new BigDecimal(("998.00")));
		OrderItemRepresentation orderItem4 = new OrderItemRepresentation("002003", "中国银象棋12g", new BigDecimal("698.00"), new BigDecimal("5"), new BigDecimal(("3490.00")));
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		orderItems.add(orderItem3);
		orderItems.add(orderItem4);
		return orderItems;
	}
}
