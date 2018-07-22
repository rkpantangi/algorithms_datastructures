package com.algod.test;

public class EfficientPower {

	public static void main(String[] args) {
		System.out.println("efficient power - " + efficientPower(2, 4));
		System.out.println(2 << 1);
	}

	private static long efficientPower(long x, long n) {
		if (n == 0) return 1;
		if (n == 1) return x;
		if (n % 2 == 0) {
			return efficientPower(x * x, n/2);
		} else {
			return efficientPower(x * x, (n-1)/2);
		}
	}
}
