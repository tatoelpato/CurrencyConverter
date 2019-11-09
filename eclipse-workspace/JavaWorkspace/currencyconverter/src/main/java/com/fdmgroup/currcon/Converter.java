package com.fdmgroup.currcon;

import java.math.BigDecimal;
import java.util.HashMap;

public class Converter {
	private HashMap<String, BigDecimal> currencyMap;
	public Converter(HashMap<String, BigDecimal> currencyMap) {
		this.currencyMap = currencyMap;
	}
	
	
	public BigDecimal convert(String to, String from, BigDecimal amount) throws InvalidCurrencyException {
		to = to.toUpperCase();
		from = from.toUpperCase();
		Validator validate = new Validator(currencyMap);
		BigDecimal exchangeRate;
		if(validate.validCurrency(to)&&validate.validCurrency(from)) 
		{
			if(from.equals(to)) 
			{
				exchangeRate = BigDecimal.valueOf(1);
			}
			
			else if(from.equals("EURO")) 
			{
				exchangeRate = currencyMap.get(to);	
				System.out.println("Test");
			} 
					
			else if(to.equals("EURO")) 
			{
				return amount.divide(currencyMap.get(from), BigDecimal.ROUND_HALF_DOWN);
			}
			
			else
			{
				exchangeRate = currencyMap.get(to).divide(currencyMap.get(from), BigDecimal.ROUND_HALF_DOWN);
			}
			
			return amount.multiply(exchangeRate);
		}else {
			System.out.println("Invalid Currency");
			return null;
		}
		
	}

}