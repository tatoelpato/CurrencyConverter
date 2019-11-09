package com.fdmgroup.tdd.gradecalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GradeCalculatorServiceTest {

	private Grade grade;

	@Before
	public void setUp() throws Exception {
		grade = new Grade();
	}

	/*
	 * @Test public void ifScoresisLessThanSeventyFiveItIsAFail() { //Assert double
	 * mark = 0.00; Grade grade = new Grade(); //Act grade.getClassification(mark);
	 * //Assert assertEquals("Fail",grade.getClassification(mark));
	 * 
	 * }
	 */

	@Test
	public void ifScoreIsLessThanSeventyFiveItIsAFail() {
		String val;
		double mark = 74.00;
		// Act
		val = grade.getClassification(mark);
		// Assert
		assertEquals("Fail", val);
	}

	@Test
	public void ifScoreIsEqualToOrGreaterThanSeventyFiveAndLessThanEightyItIsAPass() {
		String val;
		double mark = 79.99;
		// Act
		val = grade.getClassification(mark);
		// Assert
		assertEquals("Pass", val);
	}

	@Test
	public void ifScoreIsEqualToOrGreaterThanEightyAndLessThanEightyNinetyIsAMerit() {
		String val;
		double mark = 89.99;
		// Act
		val = grade.getClassification(mark);
		// Assert
		assertEquals("Merit", val);
	}

	@Test
	public void ifScoreIsEqualToOrGreaterThanNinetyOrEqualToOrGreaterThanOneHundredItIsADistinction() {
		String val;
		double mark = 100.00;
		// Act
		val = grade.getClassification(mark);
		// Assert
		assertEquals("Distinction", val);
	}
	
}
