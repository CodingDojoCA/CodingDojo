package com.comarch.kata;

import java.util.List;

public class NegativeValueException extends Exception {
	List<String> valueList;

	public NegativeValueException(List<String> valueList) {
		super(valueList.toString());
		this.valueList = valueList;
	}

}
