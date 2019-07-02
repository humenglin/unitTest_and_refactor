package com.coding.sales.pojo;

import java.math.BigDecimal;

/**
 * @author 商品信息
 *
 */
public class PaymentsInfo {
 /*商品编号*/
 private String product;
 /*商品名称*/
 private String productName;
 /*单位*/
 private String unit;
 /*价格*/
 private BigDecimal price;
 /*参与活动*/
 private String acticity;
 
 
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}

public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public String getActicity() {
	return acticity;
}
public void setActicity(String acticity) {
	this.acticity = acticity;
}
 
}
