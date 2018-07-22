package com.algod.test;

import java.util.Arrays;

public class ReducedFractionForm {

	public static void main(String[] args) {
		int [] rf = reduceFraction(new int[] {1, 2, 5}, new int[] {2, 1, 6});
		System.out.println(rf[0] + " - " + rf[1]);
	}
	
	private static int [] reduceFraction(int [] nums, int [] denoms) {
		int x = Arrays.stream(nums).reduce(1, (s, t) -> s * t);
		int y = Arrays.stream(denoms).reduce(1, (a, b) -> a * b);
		System.out.println(x + " - " + y);
		int gcdd = gcd(x, y);
		return new int[] {x / gcdd, y / gcdd };
	}
	
	private static int gcd(int a, int b) {
	       // Everything divides 0 
	        if (a == 0 || b == 0)
	           return 0;
	      
	        // base case
	        if (a == b)
	            return a;
	      
	        // a is greater
	        if (a > b)
	            return gcd(a-b, b);
	        return gcd(a, b-a);
		}
}
