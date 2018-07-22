package com.algod.test;

public class AlladinHackerRank {

	public static void main(String[] args) {
		String e = encode1("Welcome");
		System.out.println(e);
		System.out.println(encode2("Welcome"));
		System.out.println(decode(e));
	}
	
	public static String decode(String text) {
		StringBuilder b1 = new StringBuilder(text);
		text = b1.reverse().toString();
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			char val = (char)((c - i)/2); 
			b.append(val);
		}
		return b.toString();
	}

	public static String encode1(String text) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			b.append(c += c + i);
		}
		return b.reverse().toString();
	}
	
	public static String encode2(String text) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			char val = (char) (c + c + i);
			System.out.println((int)c + " - " + val + " - " + (int)val);
			b.append(val);
		}
		return b.reverse().toString();
	}

}
