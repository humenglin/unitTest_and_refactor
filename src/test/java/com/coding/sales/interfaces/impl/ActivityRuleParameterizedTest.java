package com.coding.sales.interfaces.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ActivityRuleParameterizedTest {
	@Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        Object[][] data = new Object[][]{
        	{new BigDecimal(1000), new BigDecimal(2), BigDecimal.ZERO, "activity_1000", new BigDecimal(20)},
        	{new BigDecimal(1000), new BigDecimal(2), new BigDecimal(30), "activity_1000", new BigDecimal(30)},
        	
        	{new BigDecimal(1000), new BigDecimal(2), BigDecimal.ZERO, "activity_2000", new BigDecimal(30)},
        	{new BigDecimal(1000), new BigDecimal(2), new BigDecimal(40), "activity_1000", new BigDecimal(40)},
        	
        	{new BigDecimal(1500), new BigDecimal(2), BigDecimal.ZERO, "activity_3000", new BigDecimal(350)},
        	{new BigDecimal(1500), new BigDecimal(2), new BigDecimal(400), "activity_3000", new BigDecimal(400)},
        	
        	{new BigDecimal(1000), new BigDecimal(3), BigDecimal.ZERO, "activity_3_half", new BigDecimal(500)},
        	{new BigDecimal(1000), new BigDecimal(3), new BigDecimal(600), "activity_3_half", new BigDecimal(600)},
        	
        	{new BigDecimal(1000), new BigDecimal(5), BigDecimal.ZERO, "activity_3_send_one", new BigDecimal(1000)},
        	{new BigDecimal(1000), new BigDecimal(5), new BigDecimal(1200), "activity_3_send_one", new BigDecimal(1200)},
        };

        return Arrays.asList(data);
    }
    private BigDecimal price;
    private BigDecimal goodsAmount;
    private BigDecimal discountOfactivity;
    private String activityType;
    BigDecimal discountPriceOfactivity;
    
	public ActivityRuleParameterizedTest(BigDecimal price, BigDecimal goodsAmount, BigDecimal discountOfactivity,
			String activityType, BigDecimal discountPriceOfactivity) {
		this.price = price;
		this.goodsAmount = goodsAmount;
		this.discountOfactivity = discountOfactivity;
		this.activityType = activityType;
		this.discountOfactivity = discountPriceOfactivity;
	}

	@Test
	public void should_price_after_activity() throws Exception {
		ActivityRuleImpl activityRule = new ActivityRuleImpl();
		BigDecimal discountPriceActual = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		Assertions.assertThat(discountPriceActual).isEqualByComparingTo(discountOfactivity);
	}
	
	
}
