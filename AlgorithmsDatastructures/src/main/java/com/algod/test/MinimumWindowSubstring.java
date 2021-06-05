package com.algod.test;

import java.util.HashMap;

/**
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t.
 * If there is no such window in s that covers all characters in t, return the empty string "".
 * @author Ram
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println("result = " + minWindowSubstring("ADOBECODEBANC", "ABC"));

		System.out.println("result = " + minWindowSubstring("ADOBECODEBANC", "ABCB"));

		System.out.println("result = " + minWindowSubstring("ABCA", "AB"));

		System.out.println("result = " + minWindowSubstring("A", "A"));

	}

	private static class Tracker {
		private final HashMap<Character, Data> map = new HashMap<>();

		private static class Data {
			int expected;
			int seen;
		}

		public Tracker(String t) {
			for (int i=0;i<t.length();i++) {
				char ch = t.charAt(i);
				if (map.containsKey(ch)) {
					Data d = map.get(ch);
					d.expected++;
				} else {
					Data d = new Data();
					d.expected++;
					map.put(ch, d);
				}
			}
		}

		public void put(Character ch) {
			Data d = map.get(ch);
			d.seen++;
		}

		public boolean isStringFound() {
			for (Data d : map.values()) {
				if (d.seen != d.expected) {
					return false;
				}
			}
			return true;
		}

		public void reduce(Character ch) {
			Data d = map.get(ch);
			d.seen--;
		}
	}

	private static String minWindowSubstring(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
		if (t.length() == 1) {
			if (s.indexOf(t.charAt(0)) >= 0) {
				return t;
			} else {
				return "";
			}
		}

		/*
			s = "ADOBECODEBANC"
			t = "ABC"

			st =0, end=0

		 */
		int st=0;
		int minst=-1;
		int minend=-1;
		int minLength = s.length() + 1;
		Tracker tracker = new Tracker(t);
		for (int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if (t.indexOf(ch) >= 0) {
				tracker.put(ch);
				// keep checking as long as the string is there, this is necessary when s has duplicate characters from t
				while (tracker.isStringFound()) {
					System.out.println("found - " + st + " , " + i + ", " + s.substring(st, i+1));
					int length = i-st+1;
					if (length < minLength) {
						minst = st;
						minend = i;
						minLength = length;
					}

					tracker.reduce(s.charAt(st++));
					// advance the start pointer until we find the next character present in the target
					for (int j=st;j<s.length();j++) {
						char nch = s.charAt(j);
						if (t.indexOf(nch) >= 0) {
							st=j;
							break;
						}
					}
				}
			}
		}
		if (minst == -1) {
			return "";
		}
		return s.substring(minst, minend+1);
	}
}
