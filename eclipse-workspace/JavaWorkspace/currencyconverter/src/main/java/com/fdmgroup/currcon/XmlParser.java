package com.fdmgroup.currcon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
public class XmlParser implements Parsable{
	private HashMap<String, BigDecimal>currencyMap;

	@Override
	public HashMap<String, BigDecimal> parse(File file) throws FileInvalidFormatException{
		currencyMap = new HashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String nextLine = br.readLine();
			
			while(nextLine != null) {
				if (nextLine.matches("(<Cube rate)+.*")) {
					String[] splitLine = nextLine.split("\"");
					currencyMap.put(splitLine[3], BigDecimal.valueOf(Double.valueOf(splitLine[1])));
				}
				nextLine = br.readLine();
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("Error file not found: "+ file);
		}catch(IOException e) {
			System.out.println("Error, you messed up");
		}
		if (currencyMap.size() == 0) {
			throw new FileInvalidFormatException(file + " does not contain any <Cube rate=\"*\" currency=\"*\"/> elements");
		}
		
		return currencyMap;
	}
}