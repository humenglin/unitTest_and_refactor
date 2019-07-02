package com.coding.sales.interfaces.impl;

import java.math.BigDecimal;

import com.coding.sales.interfaces.CardInfoInteface;
import com.coding.sales.pojo.CardInfo;


/**
 * @author Administrator
 * 根据不同积分返回不同的卡种
 *
 */
public class CardCreateFactory  implements CardInfoInteface{

	@Override
	public CardInfo createCard(int memberPoints) {
		if(memberPoints<10000) {
			return new CardInfo("普卡",new BigDecimal(1));
		}
		if(memberPoints>=10000&&memberPoints<50000) {
			return new CardInfo("金卡",new BigDecimal(1.5));
		}
		if(memberPoints>=50000&&memberPoints<100000) {
			return new CardInfo("白金卡",new BigDecimal(1.8));
		}
		return new CardInfo("钻石卡",new BigDecimal(2));
	}

}
