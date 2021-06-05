package com.algod.test.math;

public class TestMath {

	public static void main(String[] args) {
		double d1 = 3.56;
		double d2 = 3.587394343;
		double tick = 0.01;
		double d3 = (d2-d1);
		System.out.println(roundNumber(4.234234, 0.1));
		System.out.println(roundNumber(5.784234, 0.1));
		System.out.println(roundNumber2(5.788234, 2));
		
		testBitOperations();
	}

	private static void testBitOperations() {
		byte b = 1;
		b = (byte) (b << 2);
		System.out.println("b - " + b);
		System.out.println("r - " + (1 << (10 % 8)));
	}
	
	private static double roundNumber(double num, double rounding) {
		System.out.println(StrictMath.round(num/rounding));
		return StrictMath.round(num/rounding)*rounding;
	}
	
	private static double roundNumber2(double num, double noOfDecimals) {
		double newNum = Math.floor(num * Math.pow(10, noOfDecimals) + 0.5) / Math.pow(10, noOfDecimals);
		return newNum;
	}

}
