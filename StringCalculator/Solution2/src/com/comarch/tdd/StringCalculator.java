package com.comarch.tdd;

import com.comarch.tdd.exceptions.NegativeNumberException;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kleko on 2014-05-16.
 */
public class StringCalculator {

	private String regexDelimiter = "[,\n]";

	public int add(String numbers) throws Exception {
		String belowZero = "";
		int sum = 0;
		if (!numbers.isEmpty()) {
			if (numbers.startsWith("//")) {
				numbers = updateNumbersAndSetDelimiter(numbers);
			}
			String[] arrays = numbers.split(regexDelimiter);
			for (String number : arrays) {
				Integer parsed = Integer.parseInt(number);
				if (parsed < 0) {
					belowZero += " " + parsed;
				} else if (parsed <= 1000) {
					sum += parsed;
				}
			}
		}
		if (!belowZero.isEmpty()) {
			throw new NegativeNumberException("negatives not allowed; negatives=" + belowZero);
		}
		return sum;
	}

	private String updateNumbersAndSetDelimiter(String numbers) {
		int indexOfNewLine = numbers.indexOf("\n");
		regexDelimiter = numbers.substring(2, indexOfNewLine);
		regexDelimiter = regexDelimiter.substring(1, regexDelimiter.length() - 1);
		regexDelimiter = regexDelimiter.replace("*", "\\*");
		return numbers.substring(indexOfNewLine + 1);
	}
}
