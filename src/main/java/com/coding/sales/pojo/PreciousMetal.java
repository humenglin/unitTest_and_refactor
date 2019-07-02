package com.coding.sales.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 商品信息
 *
 */
public class PreciousMetal {
	/* 商品编号 */
	private String product;
	/* 商品名称 */
	private String productName;
	/* 单位 */
	private String unit;
	/* 价格 */
	private BigDecimal price;
	/* 参与活动 */
	private List<String> acticity = new ArrayList<String>();
	/* 代金券 */
	private String voucher;

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

	public List<String> getActicity() {
		return acticity;
	}

	public void setActicity(List<String> acticity) {
		this.acticity = acticity;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

}
