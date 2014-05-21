package com.comarch.fizzbuzz;

public class AlaMaKotaChecker {

	public boolean isFizz(int i) {
		return i % 3 == 0 && i % 5 != 0;
	}

	public boolean isBuzz(int i) {
		return i % 5 == 0 && i % 3 != 0;
	}

	public boolean isFizzBuzz(int i){
		return i%5==0 && i%3==0;
	}

}
