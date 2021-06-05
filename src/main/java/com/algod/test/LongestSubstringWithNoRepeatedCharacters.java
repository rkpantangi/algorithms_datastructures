package com.algod.test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is also a two pointer solution
 */
public class LongestSubstringWithNoRepeatedCharacters {

	public static void main(String[] args) {
		System.out.println(getLongest("ABCED"));
		System.out.println(getLongest("xyabcbaefx"));
		System.out.println(getLongest("bbbbb"));
		System.out.println(getLongest("abababa"));
		System.out.println(getLongest("abcdaefghia"));
		System.out.println(getLongest("abcdaefghi"));
		System.out.println(getLongest("abcdadefghai"));
		System.out.println(getLongest("abcbaed"));
		System.out.println(getLongest("abcbaec"));
		System.out.println(getLongest("aaaaaaa"));
	}

	private static String getLongest(String s) {
		Map<Character, Integer> indexMap = new HashMap<>();
		int maxst=0;
		int maxend=s.length()-1;
		int maxlength=0;
		int st=0;
		for (int end=0;end<s.length();end++) {
			char endc = s.charAt(end);
			if (indexMap.containsKey(endc)) {
				int length = (end - st);
				if (length > maxlength) {
					maxst = st;
					maxend = end-1;
					maxlength = length;
				}
				st = Math.max(st, indexMap.get(endc) + 1);
			}
			indexMap.put(endc, end);
		}
		return s.substring(maxst, maxend+1);
	}
}

