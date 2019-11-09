package com.fdmgroup.currcon;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Client {

	public static void main(String... strings) throws FileInvalidFormatException, InvalidCurrencyException, IOException, InterruptedException {
		boolean doConversion = true;
		String choice;
		
		File xmlFile = new File("src/main/resources/eurofxref-daily.xml");
		XmlParser xmlReader = new XmlParser();
		HashMap<String, BigDecimal> currencyMap = xmlReader.parse(xmlFile);
		Converter myConverter = new Converter(currencyMap);
		Validator validator = new Validator(currencyMap);
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Welcome to Currency Coverter v.1.0\n");
		
		while(doConversion) {
			System.out.print("Please enter TO currency: ");
			String to = myScanner.next();
			to = to.toUpperCase();
			while (!validator.validCurrency(to)) {
				System.out.println(to + " is an invalid currency. Please enter a valid TO currency.");
				to = myScanner.next().toUpperCase();
			}

			System.out.print("Please enter FROM currency: ");
			String from = myScanner.next();
			from = from.toUpperCase();

			while (!validator.validCurrency(from)) {
				System.out.println(from + " is an invalid currency. Please enter a valid FROM currency.");
				from = myScanner.next().toUpperCase();
			}

			System.out.print("Please enter amount in " + from + ":");
			String amountString = myScanner.next();
			validator.checkIsNumber(amountString);

			BigDecimal amountToConvert = BigDecimal.valueOf(Double.valueOf(amountString));
			System.out.println();

			BigDecimal convertedAmount = myConverter.convert(to, from, amountToConvert).setScale(2,
					BigDecimal.ROUND_HALF_UP);
			System.out.println(amountString + " " + from + " equals " + convertedAmount+ " in "+ to);
			
			System.out.print("Do you want to do another Conversion?");
			choice = myScanner.next();
			if(!choice.matches("^[yY].*")){doConversion = false;}
		}
		myScanner.close();
	}
	
}
