package com.coding.sales.init;

import java.util.HashMap;
import java.util.Map;

import com.coding.sales.pojo.Member;

public class Members {
	
	public static Map<String, Member> getMembers() {
		String memberNo1 = "6236609999";
		Member member1 = new Member(memberNo1, "马丁", "普卡", 9860);
		
		String memberNo2 = "6630009999";
		Member member2 = new Member(memberNo2, "王立", "金卡", 48860);
		
		String memberNo3 = "8230009999";
		Member member3 = new Member(memberNo3, "李想", "白金卡", 98860);
		
		String memberNo4 = "9230009999";
		Member member4 = new Member(memberNo4, "张三", "钻石卡", 198860);
		
		Map<String, Member> members = new HashMap<String, Member> ();
		members.put(memberNo1, member1);
		members.put(memberNo2, member2);
		members.put(memberNo3, member3);
		members.put(memberNo4, member4);
		return members;
	}

}
