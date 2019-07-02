package com.coding.sales.pojo;

import java.math.BigDecimal;

/**
 * @author 卡信息
 *
 */
public class CardInfo {
	//卡名称
	private String memberType;
	//积分倍数
	private BigDecimal pointMutiple;
	
	public CardInfo(String memberType, BigDecimal pointMutiple) {
		this.memberType = memberType;
		this.pointMutiple = pointMutiple;
	}
	public String getMemberType() {
		return memberType;
	}
	public BigDecimal getPointMutiple() {
		return pointMutiple;
	}
	
}
