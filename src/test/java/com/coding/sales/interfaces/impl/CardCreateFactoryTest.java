package com.coding.sales.interfaces.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.coding.sales.pojo.CardInfo;

@RunWith(Parameterized.class)
public class CardCreateFactoryTest {
	@Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        Object[][] data = new Object[][]{
        	{9999, "普卡", new BigDecimal(1)},
        	{10000, "金卡", new BigDecimal(1.5)},
        	{10001, "金卡", new BigDecimal(1.5)},
        	{49999, "金卡", new BigDecimal(1.5)},
        	{50000, "白金卡", new BigDecimal(1.8)},
        	{99999, "白金卡", new BigDecimal(1.8)},
        	{100000, "钻石卡", new BigDecimal(2)},
        	{500000, "钻石卡", new BigDecimal(2)},
        };

        return Arrays.asList(data);
    }
    private int memberPoints;
    private String memberType;
    private BigDecimal pointMutiple;
    
	public CardCreateFactoryTest(int memberPoints, String memberType, BigDecimal pointMutiple) {
		this.memberPoints = memberPoints;
		this.memberType = memberType;
		this.pointMutiple = pointMutiple;
	}
	
	@Test
	public void should_return_memberType_info_given_memberPoints() {
		CardCreateFactory cardCreateFactory = new CardCreateFactory();
		CardInfo cardInfoActual = cardCreateFactory.createCard(memberPoints);
		
		Assertions.assertThat(cardInfoActual.getMemberType()).isEqualTo(memberType);
		Assertions.assertThat(cardInfoActual.getPointMutiple()).isEqualByComparingTo(pointMutiple);
	}

	@Test
	public void should_return_memberType_when_createCard_given_memberPoints_is_9999() {
		CardCreateFactory cardCreateFactory = new CardCreateFactory();
		int memberPoints = 9999;
		String  memberType = "普卡";
		BigDecimal pointMutiple = new BigDecimal(1);
		CardInfo cardInfoExpected = generateCardInfo(memberType, pointMutiple);
		
		CardInfo cardInfoActual = cardCreateFactory.createCard(memberPoints);
		
		Assertions.assertThat(cardInfoActual).isEqualToComparingFieldByField(cardInfoExpected);
	}

	private CardInfo generateCardInfo(String memberType, BigDecimal pointMutiple) {
		return new CardInfo(memberType, pointMutiple);
	}
}
