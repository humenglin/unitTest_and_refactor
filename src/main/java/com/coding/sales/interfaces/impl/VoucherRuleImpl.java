package com.coding.sales.interfaces.impl;

import java.math.BigDecimal;

import com.coding.sales.enums.ActicityEnums;
import com.coding.sales.interfaces.VoucherRuleInteface;

/**
 * @author Administrator
 *代金券处理类
 */
public class VoucherRuleImpl implements VoucherRuleInteface {

	@Override
	public BigDecimal voucherRule(String voucher, String discountVor, BigDecimal discount,
			BigDecimal goodsTotalAmount) {
		if (ActicityEnums.voucher_9.toString().equals(voucher) && "9折券".equals(discountVor)) {
			BigDecimal discount_voucher_9 = goodsTotalAmount.multiply(new BigDecimal(0.1));
			if (discount.compareTo(discount_voucher_9) == -1) {
				discount = discount_voucher_9;
			}
			return discount;
		}

		BigDecimal discount_voucher_95 = goodsTotalAmount.multiply(new BigDecimal(0.05));
		if (discount.compareTo(discount_voucher_95) == -1) {
			discount = discount_voucher_95;
		}
		return discount;

	}

}
