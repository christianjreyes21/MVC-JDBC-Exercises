package bpi.forex.utility;

import bpi.forex.model.ForexBean;

public class Factory {

	public static ForexBean getInstance(double phpAmount, String currencyType) {
		
		ForexBean forex = new ForexBean();
		forex.setPhpAmount(phpAmount);
		forex.setCurrencyType(currencyType.toUpperCase());
		forex.convertAmount();
		return forex;
	}
}
