package com.algod.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class PermutationOfString {

	public static void main(String[] args) {
		String s = "abcd";
		List<String> perms = getPermutations(s);
		
		int noOfPerms = IntStream.rangeClosed(2, s.length()).reduce(1, (x, y) -> x * y);
		System.out.println("No of permutations expected - " + noOfPerms);
		System.out.println(perms);

		s = "aacd";
		TreeSet<String> dperms = getPermutationsWithDuplicateCharacters(s);
		
		noOfPerms = IntStream.rangeClosed(2, s.length()).reduce(1, (x, y) -> x * y);
		System.out.println("No of permutations expected - " + noOfPerms);
		System.out.println(dperms);
	}

	private static TreeSet<String> getPermutationsWithDuplicateCharacters(final String s) {
		if (s == null) return new TreeSet<>();
		if (s.length() == 1) {
			TreeSet<String> ts = new TreeSet<String>();
			ts.add(s);
			return ts;
		};
		
		TreeSet<String> perms = new TreeSet<>();
		for (int i=0;i<s.length();i++) {
			String prefix = s.charAt(i) + "";
			String rest = "";
			for (int j=0;j<s.length();j++) {
				if (i!=j) {
					rest += s.charAt(j);
				}
			}
			List<String> subperms = getPermutations(rest);
			for (String each : subperms) {
				perms.add(prefix + each);
			}
		}
		return perms;
	}

	private static List<String> getPermutations(String s) {
		if (s == null) return new ArrayList<>();
		if (s.length() == 1) return Arrays.asList(s);
		
		List<String> perms = new ArrayList<>();
		for (int i=0;i<s.length();i++) {
			String prefix = s.charAt(i) + "";
			String rest = "";
			for (int j=0;j<s.length();j++) {
				if (i!=j) {
					rest += s.charAt(j);
				}
			}
			List<String> subperms = getPermutations(rest);
			for (String each : subperms) {
				perms.add(prefix + each);
			}
		}
		return perms;
	}

}