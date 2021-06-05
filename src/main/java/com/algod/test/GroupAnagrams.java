package com.algod.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Write a method to sort an array of Strings so that all the anagrams are next to each other.
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		List<String> strs = Arrays.asList("abc", "xyz", "bca", "yxz");
		System.out.println(groupAnagrams(strs));
	}
	
	private static List<String> groupAnagrams(List<String> strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		
		for (String s : strs) {
			String ss = getSortedString(s);
			List<String> val = map.getOrDefault(ss, new ArrayList<>());
			val.add(s);
			map.put(ss, val);
		}
		
		List<String> groupedAnagrams = new ArrayList<>();
		for (List<String> s : map.values()) {
			groupedAnagrams.addAll(s);
		}
		return groupedAnagrams;
	}
	
	private static String getSortedString(String s) {
		char[] ss = s.toCharArray();
		Arrays.sort(ss);
		return new String(ss);
	}

}
