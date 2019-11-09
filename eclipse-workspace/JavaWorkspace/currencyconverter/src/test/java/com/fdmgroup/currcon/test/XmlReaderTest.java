package com.fdmgroup.currcon.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.currcon.FileInvalidFormatException;
import com.fdmgroup.currcon.XmlParser;

public class XmlReaderTest {

	private XmlParser xmlReader;
	private File xmlFile;
	private File xmlBadFile;
	private HashMap<String, BigDecimal>currencyMap;
	//Test that the xmlReader is about to read in the data from the xml file
	
	@Before
	public void setup() {
		xmlReader = new XmlParser();
		xmlFile = new File("src/main/resources/eurofxref-daily.xml");
		xmlBadFile = new File("src/test/resources/eurofxref-dailybad.xml");
	}
	
	
	
	@Test
	public void XmlFileReaderCountTest() throws FileInvalidFormatException {
		//Arrange
		currencyMap = xmlReader.parse(xmlFile);
		//Act
		int expectedCount = 32;
		int actualCount = currencyMap.size();
		//Assert
		assertEquals(expectedCount, actualCount);
	}

	@Test
	public void XmlFileReaderPairTest() throws FileInvalidFormatException {
		//Arrange
		currencyMap = xmlReader.parse(xmlFile);
		//Act
		BigDecimal expectedValForPHP = new BigDecimal("56.969");
		BigDecimal actualValForPHP = currencyMap.get("PHP");
		//Assert
		assertEquals(expectedValForPHP, actualValForPHP);
	}
	
	@Test
	public void XmlFileReaderPairTest2() throws FileInvalidFormatException {
		//Arrange
		currencyMap = xmlReader.parse(xmlFile);
		//Act
		BigDecimal expectedValForUSD = new BigDecimal("1.1130");
		BigDecimal actualValForUSD = currencyMap.get("USD");
		//Assert
		assertEquals(expectedValForUSD, actualValForUSD);
	}
	
	@Test(expected = FileInvalidFormatException.class)
	public void XmlFileReaderBadFileTest() throws FileInvalidFormatException {
		currencyMap = xmlReader.parse(xmlBadFile);
	}
	
}
