package com.algod.test;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "abcdak";
		String s2 = "acbcf";
		
		String lcss = getLongestCommonSubsequence(s1, s2);
		System.out.println("LCSubSeq - " + lcss);

//		s1 = "zxabcdezy";
//		s2 = "yzabcdezx";
//		
//		lcss = getLongestCommonSubsequence(s1, s2);
//		System.out.println("LCSubSeq - " + lcss);
	}

	private static String getLongestCommonSubsequence(String s1, String s2) {
		int [][] lcss = new int [s1.length()+1][s2.length()+1];
		pretty2DArrayPrint(lcss);
		
		int max = 0;
		for (int i=1;i<=s1.length();i++) {
			for (int j=1;j<=s2.length();j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					lcss[i][j] = lcss[i-1][j-1] + 1;
					if (max < lcss[i][j]) { 
						max = lcss[i][j];
					}
				} else {
					lcss[i][j] = Math.max(lcss[i][j-1], lcss[i-1][j]);
				}
			}
		}
		System.out.println();
		pretty2DArrayPrint(lcss);
		
		System.out.println("Max length of LCSubSeq - " + max);
		
		String maxlcs = "";
		int i=s1.length();
		int j=s2.length();
		while (i>=1 && j>=1) {
			if (lcss[i-1][j-1] >= lcss[i-1][j] && lcss[i-1][j-1] >= lcss[i][j-1]) {
				if (lcss[i-1][j-1] < lcss[i][j]) {
					maxlcs = s1.charAt(i-1) + maxlcs;
				}
				i=i-1;
				j=j-1;
			} else if (lcss[i-1][j] > lcss[i][j-1]) {
				i=i-1;
			} else if (lcss[i-1][j] < lcss[i][j-1]) {
				j=j-1;
			}
		}
		return maxlcs;
	}
	
	private static void pretty2DArrayPrint(int [][] arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
