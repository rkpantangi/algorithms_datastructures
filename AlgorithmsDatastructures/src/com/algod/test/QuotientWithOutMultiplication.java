package com.algod.test;

/**
 * Compute the Quotient without using multiplication, division, modulo operations. It should be efficient for large dividends
 */
public class QuotientWithOutMultiplication {
	public static void main(String[] args) {
		System.out.println(getQuotient(10, 3));
		System.out.println(getQuotient(-10, -3));
		
		System.out.println(getQuotient(-10, 3));
		System.out.println(getQuotient(10, -3));
		
		System.out.println(getQuotient(2000000, 3));
		
		System.out.println(getQuotient(4, 0));
		System.out.println(getQuotient(4, 4));
		System.out.println(getQuotient(3, 4));
		System.out.println(getQuotient(0, 4));
	}
	
	private static int getQuotient(int dividend, int divisor) {
		boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		if (divisor == 0) return Integer.MIN_VALUE;
		if (dividend < divisor) return 0;
		if (dividend == divisor) return 1;
		
		int count = 0;
		int sum = divisor;
		int quotient = 1;
		int totalsum = divisor;
		while(true) {
			sum = sum + sum;
			totalsum += sum;
			count++;
			quotient = quotient + (1<<(count));
			if (dividend <= totalsum) {
				break;
			}
		}
		
		if (dividend < totalsum) {
			while(true) {
				totalsum = totalsum - divisor;
				quotient--;
				if (totalsum < dividend) {
					break;
				}
			}
		}
		
		if (negative) {
			return -quotient;
		} else {
			return quotient;
		}
	}
}
