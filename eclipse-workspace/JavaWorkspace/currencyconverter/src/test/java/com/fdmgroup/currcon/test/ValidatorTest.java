package com.fdmgroup.currcon.test;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.currcon.FileInvalidFormatException;
import com.fdmgroup.currcon.InvalidCurrencyException;
import com.fdmgroup.currcon.Validator;
import com.fdmgroup.currcon.XmlParser;

public class ValidatorTest {
	private XmlParser xmlReader;
	private File xmlFile;
	private HashMap<String, BigDecimal> currencyMap;
	@Before
	public void setup() throws FileInvalidFormatException {
		 xmlReader = new XmlParser();
		 xmlFile = new File("src/main/resources/eurofxref-daily.xml");
		 currencyMap = xmlReader.parse(xmlFile);
	}
	
	@Test(expected = InvalidCurrencyException.class)
	public void test_ValidatorThrowsInvalidCurrencyExceptionWhenGivenAnInvalidCurrency() throws InvalidCurrencyException{	
		Validator validator = new Validator(currencyMap);
		validator.validCurrency("Ramiro");
	}

}
