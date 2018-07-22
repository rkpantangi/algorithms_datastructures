package com.algod.test;

public class Rounding {
	public static void main(String[] args) {
		System.out.println(roundNumber(22.8655, 2));
	}
	
	private static double roundNumber(double num, int decimals) {
		int rounded = (int) (num * Math.pow(10, decimals+1));
		if (rounded % 10 > 5) {
			rounded = rounded / 10 + 1;
		} else {
			rounded = rounded / 10;
		}
		return rounded / Math.pow(10, decimals);
	}
}
