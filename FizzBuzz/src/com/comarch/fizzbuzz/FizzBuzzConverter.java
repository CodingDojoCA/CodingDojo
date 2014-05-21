package com.comarch.fizzbuzz;

import java.util.ArrayList;

public class FizzBuzzConverter {
	AlaMaKotaChecker checker;

	public FizzBuzzConverter(AlaMaKotaChecker checker) {
		this.checker = checker;
	}

	public String getValue(int i) {
		if (checker.isBuzz(i)) {
			return "Buzz";
		} else if (checker.isFizz(i)) {
			return "Fizz";
		} else if (checker.isFizzBuzz(i)) {
			return "FizzBuzz";
		} else {
			return "" + i;
		}
	}

	public ArrayList<String> convertRange(int i, int j) {
		ArrayList list = new ArrayList<String>();

		for(int a = i;a<=j;a++){
			list.add(getValue(a));
		}
		return list;
	}
}
