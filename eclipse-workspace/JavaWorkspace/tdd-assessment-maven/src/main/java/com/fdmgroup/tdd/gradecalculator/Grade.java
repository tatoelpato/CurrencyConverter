package com.fdmgroup.tdd.gradecalculator;

public class Grade implements GradeCalculatorService {

	private String score;

	public String getClassification(double mark) {

		if (mark < 75.00) {
			return "Fail";
		} else if ((mark < 80)) {
			return "Pass";
		} else if ((mark < 90)) {
			return "Merit";
		} else if ((mark <= 100)) {
			return "Distinction";
		}
		return score;
	}
}
