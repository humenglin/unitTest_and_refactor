package com.coding.sales.interfaces.impl;

import java.math.BigDecimal;

import com.coding.sales.common.ExceptionConstans;
import com.coding.sales.enums.ActicityEnums;
import com.coding.sales.interfaces.ActivityRuleInteface;

/**
 * @author Administrator
 *活动规则调试方法
 */
public class ActivityRuleImpl implements ActivityRuleInteface {

	/**
	 * @param price 单价
	 * @param goodsAmount 商品总数
	 * @param discountOfactivity 上次的折扣金额
	 * @param activityType 活动类型
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BigDecimal activityRule(BigDecimal price,BigDecimal goodsAmount, BigDecimal discountOfactivity,String activityType) throws Exception {
		BigDecimal goodsTotalAmount = price.multiply(goodsAmount);
		if (ActicityEnums.activity_1000.toString().equals(activityType)) {
			BigDecimal discount_1000 = new BigDecimal(
					goodsTotalAmount.divide(new BigDecimal("1000")).intValue() * 10);
			
			if (discountOfactivity.compareTo(discount_1000) == -1) {
				discountOfactivity = discount_1000;
			}
			return discountOfactivity;
		}
		if (ActicityEnums.activity_2000.toString().equals(activityType)) {
			BigDecimal discount_2000 = new BigDecimal(
					goodsTotalAmount.divide(new BigDecimal("2000")).intValue() * 30);
			if (discountOfactivity.compareTo(discount_2000) == -1) {
				discountOfactivity = discount_2000;
			}
			return discountOfactivity;
		}

		if (ActicityEnums.activity_3000.toString().equals(activityType)) {
			BigDecimal bg = goodsTotalAmount.divideToIntegralValue(new BigDecimal("3000"));
			BigDecimal discount_3000 = new BigDecimal(bg.intValue() * 350);
			if (discountOfactivity.compareTo(discount_3000) == -1) {
				discountOfactivity = discount_3000;
			}
			return discountOfactivity;
		}

		if (ActicityEnums.activity_3_half.toString().equals(activityType)) {
			if (goodsAmount.compareTo(new BigDecimal("3")) >= 0) {
				BigDecimal discount_activity_3_half = price.multiply(new BigDecimal(0.5));
				if (discountOfactivity.compareTo(discount_activity_3_half) == -1) {
					discountOfactivity = discount_activity_3_half;
				}
			}
			return discountOfactivity;
		}

		if (ActicityEnums.activity_3_send_one.toString().equals(activityType)) {
			if (goodsAmount.compareTo(new BigDecimal("4")) >= 0) {
				if (discountOfactivity.compareTo(price) == -1) {
					discountOfactivity = price;
				}
			}
			return discountOfactivity;
		}
		
		throw new Exception(ExceptionConstans.ACTIVITY_NOT_EXIT);
	}

}
