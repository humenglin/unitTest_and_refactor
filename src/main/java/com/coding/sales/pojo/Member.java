package com.coding.sales.pojo;

/**
 * 会员信息
 * @author humenglin
 *
 */
public class Member {

	private String memberNo;
	
	private String memberName;
	
	private String memberType;
	
	private int memberPoints;

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getMemberPoints() {
		return memberPoints;
	}

	public void setMemberPoints(int memberPoints) {
		this.memberPoints = memberPoints;
	}
}
