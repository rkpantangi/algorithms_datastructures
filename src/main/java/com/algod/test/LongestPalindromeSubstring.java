package com.algod.test;

/**
 * Longest Palindrome substring - meaning the characters in the Palindrome need to be contiguous.
 */
public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String s = "abachairriahcbab";
		System.out.println(longestPalindromeSubstring(s));
		s = "abcde";
		System.out.println(longestPalindromeSubstring(s));
	}
	
	private static String longestPalindromeSubstring(String s) {
		int ms=0;
		int me=0;
		
		for (int i=0;i<s.length();i++) {
			// you expand around two centers to factor in even and odd length palindromes
			int leftlen = findAroundCenter(s, i, i);
			int rightlen = findAroundCenter(s, i, i+1);
			int len = Math.max(leftlen, rightlen);
			if (len > me-ms) {
				ms = i - (len - 1)/2;
				me = i + len/2;
			}
		}
		return s.substring(ms, me+1);
	}
	
	private static int findAroundCenter(String s, int left, int right) {
		while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}
