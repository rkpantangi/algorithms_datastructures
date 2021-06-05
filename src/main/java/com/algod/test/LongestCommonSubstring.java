package com.algod.test;

import java.util.Arrays;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1 = "GeeksforGeeks";
		String s2 = "GeeksQuiz";
		
		String lcss = getLongestCommonSubstring(s1, s2);
		System.out.println("LCS - " + lcss);

		s1 = "zxabcdezy";
		s2 = "yzabcdezx";
		
		lcss = getLongestCommonSubstring(s1, s2);
		System.out.println("LCS - " + lcss);
	}

	private static String getLongestCommonSubstring(String s1, String s2) {
		int [][] lcss = new int [s1.length()+1][s2.length()+1];
		pretty2DArrayPrint(lcss);
		
		int max = 0;
		int maxi = 0;
		int maxj = 0;
		for (int i=1;i<=s1.length();i++) {
			for (int j=1;j<=s2.length();j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					lcss[i][j] = lcss[i-1][j-1] + 1;
					if (max < lcss[i][j]) { 
						maxi=i;
						maxj=j;
						max = lcss[i][j];
					}
				}
			}
		}
		System.out.println();
		pretty2DArrayPrint(lcss);
		
		System.out.println("Max length of LCS - " + max);
		
		String maxlcs = "";
		int i=maxi;
		int j=maxj;
		while (lcss[i][j]>0) {
			maxlcs = s1.charAt(i-1) + maxlcs;
			i = i-1; j=j-1;
		}
		return maxlcs;
	}
	
	private static void pretty2DArrayPrint(int [][] arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
