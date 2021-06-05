package com.algod.test;

/**
 * Minimum edit distance between two strings - classic dynamic programming solution
 */
public class MinimumEditDistance {

	public static void main(String[] args) {
		String s1 = "sunday";
		String s2 = "saturday";
		System.out.println(minEditDistance(s1, s2));

		s1 = "geek";
		s2 = "gesek";
		System.out.println(minEditDistance(s1, s2));

		s1 = "cat";
		s2 = "cars";
		System.out.println(minEditDistance(s1, s2));

	}

	private static int minEditDistance(String s1, String s2) {
		int [][] dist = new int[s1.length()][s2.length()];
		for (int i=0;i<s1.length();i++) {
			dist[i][0] = i;
		}
		for (int j=0;j<s2.length();j++) {
			dist[0][j] = j;
		}
		
		for (int i=1;i<s1.length();i++) {
			for (int j=1;j<s2.length();j++) {
				dist[i][j] = Math.min(Math.min(dist[i-1][j], dist[i][j-1]), dist[i-1][j-1]);
				if (s1.charAt(i) != s2.charAt(j)) {
					dist[i][j] = dist[i][j]+1;
				}
			}
		}
		
		return dist[s1.length()-1][s2.length()-1];
	}

}
