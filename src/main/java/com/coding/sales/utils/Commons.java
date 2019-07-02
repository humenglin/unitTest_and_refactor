package com.coding.sales.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.coding.sales.enums.ActicityEnums;
import com.coding.sales.pojo.PaymentsInfo;

public class Commons {
	public static  Map <String,PaymentsInfo> paymentsInfo;

	
	public Commons() {
		 /*世园会五十国钱币册*/
		PaymentsInfo bookOfAmount = new PaymentsInfo();
		bookOfAmount.setProduct("001001");
		bookOfAmount.setProductName("世园会五十国钱币册");
		bookOfAmount.setPrice(new BigDecimal(998.00));
		bookOfAmount.setUnit("册");
		/*2019北京世园会纪念银章大全40g*/

		PaymentsInfo CommemorativeCoins = new PaymentsInfo();
		CommemorativeCoins.setProduct("001002");
		CommemorativeCoins.setProductName("2019北京世园会纪念银章大全40g");
		CommemorativeCoins.setPrice(new BigDecimal(1380.00));
		CommemorativeCoins.setUnit("盒");
		CommemorativeCoins.setVoucher(ActicityEnums.voucher_9.toString());
		/*招财进宝*/

		PaymentsInfo volume_up = new PaymentsInfo();
		volume_up.setProduct("003001");
		volume_up.setProductName("招财进宝");
		volume_up.setPrice(new BigDecimal(1580.00));
		volume_up.setUnit("条");
		volume_up.setVoucher(ActicityEnums.voucher_95.toString());

		 /*水晶之恋*/

		PaymentsInfo theCrystalOfLove = new PaymentsInfo();
		theCrystalOfLove.setProduct("003002");
		theCrystalOfLove.setProductName("水晶之恋");
		theCrystalOfLove.setPrice(new BigDecimal(980.00));
		theCrystalOfLove.setUnit("条");
		theCrystalOfLove.getActicity().add((ActicityEnums.activity_3_send_one.toString()));
		 /*中国经典钱币套装*/
		PaymentsInfo chainOrnament = new PaymentsInfo();
		chainOrnament.setProduct("002002");
		chainOrnament.setProductName("中国经典钱币套装");
		chainOrnament.setPrice(new BigDecimal(998.00));
		chainOrnament.setUnit("套");
		chainOrnament.getActicity().add(ActicityEnums.activity_2000.toString());
		/*守扩之羽比翼双飞4.8g*/
		PaymentsInfo flayWing = new PaymentsInfo();
		flayWing.setProduct("002001");
		flayWing.setProductName("守扩之羽比翼双飞4.8g");
		flayWing.setPrice(new BigDecimal(1080.00));
		flayWing.setUnit("条");
		flayWing.getActicity().add(ActicityEnums.activity_3_half.toString());
		flayWing.getActicity().add(ActicityEnums.activity_3_send_one.toString());
        /* 中国银象棋12g */
		PaymentsInfo chess = new PaymentsInfo();
		chess.setProduct("002003");
		chess.setProductName("中国银象棋12g");
		chess.setPrice(new BigDecimal(698.00));
		chess.setUnit("套");
		chess.getActicity().add(ActicityEnums.activity_3000.toString());
		chess.getActicity().add(ActicityEnums.activity_2000.toString());
		chess.getActicity().add(ActicityEnums.activity_1000.toString());
		chess.setVoucher(ActicityEnums.voucher_9.toString());
		
		Map <String,PaymentsInfo>  paymentsInfoMap = new HashMap<String,PaymentsInfo>();
		paymentsInfoMap.put("001001", bookOfAmount);
		paymentsInfoMap.put("001002", CommemorativeCoins);
		paymentsInfoMap.put("003001", volume_up);
		paymentsInfoMap.put("003002", theCrystalOfLove);
		paymentsInfoMap.put("002002", chainOrnament);
		paymentsInfoMap.put("002001", flayWing);
		paymentsInfoMap.put("002003", chess);

		paymentsInfo=paymentsInfoMap;
		
//		paymentsInfo

	}
}
