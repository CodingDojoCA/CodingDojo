package com.comarch.kata;

public class Checker {

	public boolean isEmpty(String number) {
		return number == "";
	}

	public String getValue(String number) {
		if (number == "0"){
			return "";
		} 
		return ""+number;
	}
	
	
}
