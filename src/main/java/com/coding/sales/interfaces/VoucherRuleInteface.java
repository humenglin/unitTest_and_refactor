package com.coding.sales.interfaces;

import java.math.BigDecimal;


/**
 * @author Administrator
 * 代金券规则接口
 *
 */
public interface VoucherRuleInteface {
	public abstract BigDecimal voucherRule(String voucher,String discountVor,BigDecimal discount,BigDecimal goodsTotalAmount) ;

}
