package bpi.forex.model;

import bpi.forex.utility.ForexValues;

//step 1 - define beans to represent data
public class ForexBean implements ForexValues{

	private double phpAmount;
	private String currencyType;
	private double convertedAmount;
	
	public double getPhpAmount() {
		return phpAmount;
	}
	public void setPhpAmount(double phpAmount) {
		this.phpAmount = phpAmount;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	
	public void convertAmount() {
		switch(getCurrencyType()) {
			case "US$":
				setConvertedAmount(getPhpAmount() / US$);
				break; //for today
			case "EURO":
				setConvertedAmount(getPhpAmount() / EURO);
				break; //for next week
			case "AUS$":
				setConvertedAmount(getPhpAmount() / AUS$);
				break; //for Sept 12
			case "YEN":	
				setConvertedAmount(getPhpAmount() / YEN);
				break; //for Sept 19
		}
	}
	
	
}
