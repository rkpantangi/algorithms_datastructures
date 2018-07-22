package com.algod.test;

public class RoundFractionToMultiple {

	public static void main(String[] args) {
		System.out.println(roundFractionToMultiple(6.6825, 0.0078125));
	}

	private static double roundFractionToMultiple(double num, double factor) {
		long sig = (long)num;
		double frac = Math.round((num - sig) / factor) * factor;
		return sig + frac;
	}
}
