package com.coding.sales.interfaces;

import com.coding.sales.pojo.CardInfo;

//卡信息接口
public interface CardInfoInteface {
//根据积分创建不同的卡类型
public abstract CardInfo createCard(int memberPoints);
}
