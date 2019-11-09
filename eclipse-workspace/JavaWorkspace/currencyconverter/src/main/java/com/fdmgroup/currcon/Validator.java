package com.fdmgroup.currcon;

import java.math.BigDecimal;
import java.util.HashMap;

public class Validator {

	private HashMap<String, BigDecimal> currencyMap;
	
	public Validator(HashMap<String, BigDecimal> currencyMap) {
		this.currencyMap = currencyMap;
	}
	
	public boolean validCurrency(String currency) {
		boolean valid = false;
		if((currencyMap.containsKey(currency.toUpperCase()) || currency.toUpperCase().equals("EURO"))) {
			valid = true;
		}
		return valid;

	}

	public void checkIsNumber(String num) throws NumberFormatException {
		try{
			Double.parseDouble(num);
		}
		catch(NumberFormatException e) {
			System.out.println(num + " is not a number.");
		}
	}
}
