package com.algod.test;

import java.util.HashMap;

public class LongestSubstringWithNoRepeatedCharacters {

	public static void main(String[] args) {
//		System.out.println(getLongest("ABCED"));
//		System.out.println(getLongest("xyabcbaefx"));
//		System.out.println(getLongest("bbbbb"));
//		System.out.println(getLongest("abababa"));
//		System.out.println(getLongest("abcdaefghia"));
		System.out.println(getLongest("abcdaefghi"));
		System.out.println(getLongest("abcdadefghi"));
		int [] var = new int[100];
		System.out.println(var.length);
		
	}

	private static String getLongest(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int i=0, m=0;
		int max = 0, mi=0, mj=-1;
		while(i<s.length()) {
			if (map.containsKey(s.charAt(i))) {
				// reset
				if (max < (i - m)) {
					max = i-m;
					mi = m;
					mj = i-1;
				}
				System.out.println(s.substring(mi, mj+1));
				m = map.put(s.charAt(i), i) + 1;
			} else {
				if (i == s.length()-1) {
					// reset
					if (max < (i - m)) {
						max = i-m;
						mi = m;
						mj = i;
					}
					System.out.println("last - " + s.substring(mi, mj+1));
				} else {
					map.put(s.charAt(i), i);
				}
			}
			i++;
		}
		return s.substring(mi, mj+1);
	}
}
