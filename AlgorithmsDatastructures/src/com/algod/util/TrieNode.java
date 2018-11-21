package com.algod.util;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Character c;
	boolean isWord;
	Map<Character, TrieNode> children = new HashMap<>();
	
	public TrieNode(Character c) {
		this.c = c;
	}
	
	public boolean addChild(Character c) {
		TrieNode n = children.get(c);
		if (n != null) return false;
		else {
			children.put(c, new TrieNode(c));
			return true;
		}
	}
	
	public boolean isWord() {
		return isWord;
	}
	
	public boolean isEndOfChain() {
		return children.isEmpty();
	}	
	
	public Character getC() {
		return c;
	}	
	
	public TrieNode getChild(Character c) {
		return children.get(c);
	}
	
	public void insertWord(String s) {
		TrieNode running = this;
		for (int i=0;i<s.length();i++) {
			TrieNode childNode = running.children.get(s.charAt(i));
			if (childNode == null) {
				childNode = new TrieNode(s.charAt(i));
				running.children.put(s.charAt(i), childNode);
			}
			running = childNode;
		}
		running.isWord = true;
	}
	
	public void print() {
		if (children != null) {
			System.out.println("Keys - " + children.keySet() + ", End Of Word - " + isEndOfChain());
			children.forEach((k, v) -> v.print());
		}
	}
}