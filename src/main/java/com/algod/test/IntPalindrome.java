package com.algod.test;

public class IntPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindromeInt(23432));
		System.out.println(isPalindromeInt(563465));
	}
	
	private static boolean isPalindromeInt(int num) {
		int lnum = num;
		int rnum = 0;
		boolean isPoly = false;
		while (true) {
			rnum = (rnum * 10) + (lnum % 10);
			lnum = lnum / 10;
			if (lnum == rnum) {
				isPoly = true;
				break;
			} else if (lnum < rnum) {
				if (lnum == (rnum / 10)) {
					isPoly = true;
				}
				break;
			}
		}
		return isPoly;
	}

}
