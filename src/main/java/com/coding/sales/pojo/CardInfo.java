package com.coding.sales.pojo;

import java.math.BigDecimal;

/**
 * @author 卡信息
 *
 */
public class CardInfo {
	//卡名称
	private String cardName;
	//积分倍数
	private BigDecimal pointMutiple;
	
	public CardInfo(String cardName,BigDecimal pointMutiple ) {
		this.cardName=cardName;
		this.pointMutiple=pointMutiple;
	}
	
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public BigDecimal getPointMutiple() {
		return pointMutiple;
	}

	public void setPointMutiple(BigDecimal pointMutiple) {
		this.pointMutiple = pointMutiple;
	}
	
}
