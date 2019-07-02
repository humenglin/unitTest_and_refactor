package com.coding.sales.interfaces;

import java.math.BigDecimal;

/**
 * @author Administrator
 *活动规则接口
 */
public interface ActivityRuleInteface {

	public abstract BigDecimal activityRule(BigDecimal price,BigDecimal goodsAmount, BigDecimal discountOfactivity,String activityType) throws Exception  ;

}
