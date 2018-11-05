package com.algod.test;

import java.util.Arrays;
import java.util.List;

/**
 * Print all the combinations in which a sentence can be split, given a set of strings that are in the dictionary
 */
public class WordBreakUsingDP {

	public static void main(String[] args) {
		List<String> dict = Arrays.asList("this", "th", "is", "famous",
				"Word", "break", "b", "r", "e", "a", "k",
				"br", "bre", "brea", "ak", "problem");

		// input String
		String str = "Wordbreakproblem";
		
		wordBreak(dict, str, "");
	}
	
	private static void wordBreak(List<String> dict, String str, String output) {
		if ("".equals(str)) {
			// reached the end of the iteration
			System.out.println(output);
			return;
		}
		for (int i=1;i<=str.length();i++) {
			String substr = str.substring(0, i);
			if (dict.contains(substr)) {
				wordBreak(dict, str.substring(i), output + " " + substr);
			}
		}
	}

}
