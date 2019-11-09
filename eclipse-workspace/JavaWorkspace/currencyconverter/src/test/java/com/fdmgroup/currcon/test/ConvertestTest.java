package com.fdmgroup.currcon.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.currcon.Converter;
import com.fdmgroup.currcon.FileInvalidFormatException;
import com.fdmgroup.currcon.InvalidCurrencyException;
import com.fdmgroup.currcon.Validator;
import com.fdmgroup.currcon.XmlParser;
public class ConvertestTest {

	private Validator validator;
	private XmlParser xmlReader;
	private HashMap<String, BigDecimal> currencyMap;
	private File xmlFile;
	
	
	@Before
	public void setup() throws FileInvalidFormatException {
		xmlReader = new XmlParser();
		xmlFile = new File("src/main/resources/eurofxref-daily.xml");
		currencyMap = xmlReader.parse(xmlFile);
		validator = new Validator(currencyMap);
	}
	
	@Test
	public void testConversionObjectCalculatesCurrencyConversion() throws InvalidCurrencyException {
		Converter myConverter = new Converter(currencyMap);
		String to = "USD";
		String from = "EURO";
		
		BigDecimal conversionRate = currencyMap.get(to);
		BigDecimal amount = new BigDecimal("150.25");
		BigDecimal expectedAmountAfterConversion = amount.multiply(conversionRate);
		BigDecimal myDollars = myConverter.convert(to, from, amount);
		
		
		assertEquals(expectedAmountAfterConversion, myDollars);
	}
	


}
