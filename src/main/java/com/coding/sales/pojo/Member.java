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

	public Member(String memberNo, String memberName, String memberType, int memberPoints) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberType = memberType;
		this.memberPoints = memberPoints;
	}

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

	public String getMemberNo() {
		return memberNo;
	}

	public String getMemberName() {
		return memberName;
	}
}
