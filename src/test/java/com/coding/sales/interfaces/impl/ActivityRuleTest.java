package com.coding.sales.interfaces.impl;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ActivityRuleTest {
	
	private ActivityRuleImpl activityRule;
	
	@Before
	public void setUp() {
		activityRule = new ActivityRuleImpl();
	}

	@Test
	public void should_calc_discount_of_activity_given_activity_1000_and_origin_discount_is_lower() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(2);
		BigDecimal discountOfactivity = BigDecimal.ZERO;
		String activityType = "activity_1000";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(20));
	}
	
	@Test
	public void should_calc_discount_of_activity_given_activity_1000_and_origin_discount_is_higher() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(2);
		BigDecimal discountOfactivity = new BigDecimal(30);
		String activityType = "activity_1000";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(30));
	}
	
	@Test
	public void should_calc_discount_of_activity_given_activity_2000_and_origin_discount_is_lower() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(2);
		BigDecimal discountOfactivity = BigDecimal.ZERO;
		String activityType = "activity_2000";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(30));
	}
	
	@Test
	public void should_calc_discount_of_activity_given_activity_2000_and_origin_discount_is_higher() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(2);
		BigDecimal discountOfactivity = new BigDecimal(40);
		String activityType = "activity_2000";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(40));
	}
	@Test
	public void should_calc_discount_of_activity_given_activity_3000_and_origin_discount_is_lower() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(3);
		BigDecimal discountOfactivity = BigDecimal.ZERO;
		String activityType = "activity_3000";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(350));
	}
	
	@Test
	public void should_calc_discount_of_activity_given_activity_3000_and_origin_discount_is_higher() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(2);
		BigDecimal discountOfactivity = new BigDecimal(400);
		String activityType = "activity_3000";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(400));
	}
	
	@Test
	public void should_calc_discount_of_activity_given_activity_3_half_and_origin_discount_is_lower() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(3);
		BigDecimal discountOfactivity = BigDecimal.ZERO;
		String activityType = "activity_3_half";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(500));
	}
	
	@Test
	public void should_calc_discount_of_activity_given_activity_3_half_and_amount_is_3_and_origin_discount_is_higher() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(3);
		BigDecimal discountOfactivity = new BigDecimal(600);
		String activityType = "activity_3_half";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(600));
	}
	
	@Test
	public void should_calc_discount_of_activity_given_activity_3_send_one_and_origin_discount_is_lower() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(4);
		BigDecimal discountOfactivity = BigDecimal.ZERO;
		String activityType = "activity_3_send_one";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(1000));
	}
	
	@Test
	public void should_calc_discount_of_activity_given_activity_3_send_one_and_origin_discount_is_higher() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(4);
		BigDecimal discountOfactivity = new BigDecimal(1200);
		String activityType = "activity_3_send_one";
		
		// WHEN
		BigDecimal discountPriceOfactivity = activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		
		// THEN
		Assertions.assertThat(discountPriceOfactivity).isEqualByComparingTo(new BigDecimal(1200));
	}
	
	@Test(expected = Exception.class)
	public void should_throw_exception_of_activity_not_exit() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(4);
		BigDecimal discountOfactivity = new BigDecimal(1200);
		String activityType = "no_activity";
				
		// WHEN
		activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
	}
	
	@Test
	public void should_throw_exception_of_activity_not_exit_and_checkout_errmsg() throws Exception {
		// GIVEN 
		BigDecimal price = new BigDecimal(1000) ;
		BigDecimal goodsAmount = new BigDecimal(4);
		BigDecimal discountOfactivity = new BigDecimal(1200);
		String activityType = "no_activity";
		
		// WHEN
		try {
			activityRule.activityRule(price, goodsAmount, discountOfactivity, activityType);
		} catch(Exception e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("activity_not_exit");
		}
	}
}
