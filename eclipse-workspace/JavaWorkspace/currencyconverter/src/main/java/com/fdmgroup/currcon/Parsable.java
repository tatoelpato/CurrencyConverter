package com.fdmgroup.currcon;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;

public interface Parsable {

	HashMap<String, BigDecimal> parse(File file) throws FileInvalidFormatException;
	
	
}
