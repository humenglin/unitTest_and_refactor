package com.coding.sales.pojo;

/**
 * 会员信息
 * @author humenglin
 *
 */
public class Member {

	private String memberNo;
	
	private String memberName;
	
	private CardInfo cardInfo;
	
	private int memberPoints;

	public Member(String memberNo, String memberName, CardInfo cardInfo, int memberPoints) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.cardInfo = cardInfo;
		this.memberPoints = memberPoints;
	}

	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
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
