package com.coding.sales.init;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.coding.sales.enums.ActicityEnums;
import com.coding.sales.pojo.PreciousMetal;

public class PreciousMetals {

	public static Map<String, PreciousMetal> getPreciousMetals() {
		 /*世园会五十国钱币册*/
		PreciousMetal bookOfAmount = new PreciousMetal();
		bookOfAmount.setProduct("001001");
		bookOfAmount.setProductName("世园会五十国钱币册");
		bookOfAmount.setPrice(new BigDecimal(998.00));
		bookOfAmount.setUnit("册");
		
		/*2019北京世园会纪念银章大全40g*/
		PreciousMetal CommemorativeCoins = new PreciousMetal();
		CommemorativeCoins.setProduct("001002");
		CommemorativeCoins.setProductName("2019北京世园会纪念银章大全40g");
		CommemorativeCoins.setPrice(new BigDecimal(1380.00));
		CommemorativeCoins.setUnit("盒");
		CommemorativeCoins.setVoucher(ActicityEnums.voucher_9.toString());
		
		/*招财进宝*/
		PreciousMetal volume_up = new PreciousMetal();
		volume_up.setProduct("003001");
		volume_up.setProductName("招财进宝");
		volume_up.setPrice(new BigDecimal(1580.00));
		volume_up.setUnit("条");
		volume_up.setVoucher(ActicityEnums.voucher_95.toString());

		 /*水晶之恋*/
		PreciousMetal theCrystalOfLove = new PreciousMetal();
		theCrystalOfLove.setProduct("003002");
		theCrystalOfLove.setProductName("水晶之恋");
		theCrystalOfLove.setPrice(new BigDecimal(980.00));
		theCrystalOfLove.setUnit("条");
		theCrystalOfLove.getActicity().add((ActicityEnums.activity_3_send_one.toString()));
		
		 /*中国经典钱币套装*/
		PreciousMetal chainOrnament = new PreciousMetal();
		chainOrnament.setProduct("002002");
		chainOrnament.setProductName("中国经典钱币套装");
		chainOrnament.setPrice(new BigDecimal(998.00));
		chainOrnament.setUnit("套");
		chainOrnament.getActicity().add(ActicityEnums.activity_2000.toString());
		
		/*守扩之羽比翼双飞4.8g*/
		PreciousMetal flayWing = new PreciousMetal();
		flayWing.setProduct("002001");
		flayWing.setProductName("守扩之羽比翼双飞4.8g");
		flayWing.setPrice(new BigDecimal(1080.00));
		flayWing.setUnit("条");
		flayWing.getActicity().add(ActicityEnums.activity_3_half.toString());
		flayWing.getActicity().add(ActicityEnums.activity_3_send_one.toString());
		
        /* 中国银象棋12g */
		PreciousMetal chess = new PreciousMetal();
		chess.setProduct("002003");
		chess.setProductName("中国银象棋12g");
		chess.setPrice(new BigDecimal(698.00));
		chess.setUnit("套");
		chess.getActicity().add(ActicityEnums.activity_3000.toString());
		chess.getActicity().add(ActicityEnums.activity_2000.toString());
		chess.getActicity().add(ActicityEnums.activity_1000.toString());
		chess.setVoucher(ActicityEnums.voucher_9.toString());
		
		Map<String,PreciousMetal>  preciousMetals = new HashMap<String,PreciousMetal>();
		preciousMetals.put("001001", bookOfAmount);
		preciousMetals.put("001002", CommemorativeCoins);
		preciousMetals.put("003001", volume_up);
		preciousMetals.put("003002", theCrystalOfLove);
		preciousMetals.put("002002", chainOrnament);
		preciousMetals.put("002001", flayWing);
		preciousMetals.put("002003", chess);
		
		return preciousMetals;
	}
	
}
