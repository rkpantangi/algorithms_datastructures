package com.algod.test;

import java.util.HashMap;
import java.util.Map;

public class TrieOperations {

	private static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		
		public boolean isEndOfWord() {
			return children.isEmpty();
		}
		
		public void print() {
			if (children != null) {
				System.out.println("Keys - " + children.keySet() + ", End Of Word - " + isEndOfWord());
				children.forEach((k, v) -> v.print());
			}
		}
	}
	
	private static void insertWord(TrieNode root, String s) {
		TrieNode running = root;
		for (int i=0;i<s.length();i++) {
			TrieNode childNode = running.children.get(s.charAt(i));
			if (childNode == null) {
				childNode = new TrieNode();
				running.children.put(s.charAt(i), childNode);
			}
			running = childNode;
		}
	}
	
	public static void main(String[] args) {
		TrieNode tn = new TrieNode();
		insertWord(tn, "abc");
		insertWord(tn, "abgl");
		insertWord(tn, "abcd");
		insertWord(tn, "cdf");
		
		tn.print();
	}

}
