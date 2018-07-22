package com.algod.test;

public class LCMOfArray {

	public static void main(String[] args) {
		usingGCD();
		gcdTest();
	}
	
	private static void usingGCD() {
		int arr [] = new int[] {2, 7, 3, 9, 4};
		
		int lcm = findLCMUsingGCD(arr, arr.length-1);
		System.out.println("lcm - " + lcm);

		arr = new int[] {1, 2, 8, 3};
		
		lcm = findLCMUsingGCD(arr, arr.length-1);
		System.out.println("lcm - " + lcm);

	}
	
	private static int findLCMUsingGCD(int arr[], int i) {
		if (i < 0) return 1;
		int prevLCM = findLCMUsingGCD(arr, i-1);
		return arr[i] * prevLCM / gcd(arr[i], prevLCM);
	}
	
	private static void gcdTest() {
		System.out.println(gcd(24, 15));
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
