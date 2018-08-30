package com.algod.test;

public class Rounding {
	public static void main(String[] args) {
		System.out.println(roundNumber(22.8645, 2));
		System.out.println(roundNumber(22.8685, 2));
		
		System.out.println(roundFractionToMultiple(6.6825, 0.0078125));
		System.out.println(roundFractionToMultiple(5.787234, 0.1));
	}
	
	private static double roundNumber(double num, int decimals) {
		double multiplier = Math.pow(10, decimals);
		double roundedNum = Math.floor(num * multiplier + 0.5) / multiplier;
		return roundedNum;
	}
	
	private static double roundFractionToMultiple(double num, double factor) {
		long sig = (long)num;
		double frac = Math.round((num - sig) / factor) * factor;
		return sig + frac;
	}
}
