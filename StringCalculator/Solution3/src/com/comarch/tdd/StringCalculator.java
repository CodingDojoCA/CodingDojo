package com.comarch.tdd;

/**
 * Created by Kleko on 2014-05-16.
 */
public class StringCalculator {
	
	private static final String DEFAULT_SEPARATOR_REGEX = ",|\n";

	public int add(String numbers) {
		int sum = 0;
		
		String delimiter = DEFAULT_SEPARATOR_REGEX;
		
		if (isDelimeterDefined(numbers)) {
			delimiter = numbers.substring(3, numbers.indexOf("\n")-1);
			numbers = numbers.substring(numbers.indexOf("\n")+1);
		}
		
		if (!numbers.isEmpty()) {
			String[] arrays = split(numbers, delimiter);
			String negativeNumbers = "";
			StringBuilder sb = new StringBuilder();
			for (String number : arrays) {
				int parsedInt = Integer.parseInt(number);
				if (parsedInt < 0) {
					negativeNumbers += parsedInt+", ";
				}
				else if (parsedInt <= 1000) {
					sum += parsedInt;
				}
			}
			
			if(!negativeNumbers.isEmpty()){
				negativeNumbers = negativeNumbers.substring(0, negativeNumbers.length()-2);
				throw new NegativeNumberPassed("Negatives not allowed, but found: " + negativeNumbers);
			}
		}
		return sum;
	}

	private String[] split(String numbers, String delimiter) {
		delimiter = delimiter.replace("*", "\\*").replace("+", "\\+");
		return numbers.split(delimiter);
	}

	private boolean isDelimeterDefined(String numbers) {
		return numbers.startsWith("//");
	}
}
