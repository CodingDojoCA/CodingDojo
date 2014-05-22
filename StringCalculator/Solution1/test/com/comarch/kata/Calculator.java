package com.comarch.kata;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	Checker checker = new Checker();

	public String[] getParams(String param) {
		if (param.length() > 1 && param.substring(0, 1).equals("/")) {
			String[] newParams = param.split("\n");
			String separator = newParams[0].substring(
					newParams[0].indexOf("[") + 1, newParams[0].indexOf("]"));
			
			return newParams[1].replace(separator, ",").split(",");
		}
		return param.split(",|\n");
	}

	public int add(String numbers) throws NegativeValueException {
		List<String> negativeValueList = new ArrayList<String>();
		String[] numberList = getParams(numbers);
		int amount = 0;
		for (String number : numberList) {
			if (!checker.isEmpty(number)) {
				int numberFromString = Integer.parseInt(checker
						.getValue(number));
				if (numberFromString < 0) {
					negativeValueList.add(number);
				} else {
					if (numberFromString < 1001)
						amount += numberFromString;
				}
			}

		}
		if (!negativeValueList.isEmpty())
			throw new NegativeValueException(negativeValueList);
		return amount;
	}

}
