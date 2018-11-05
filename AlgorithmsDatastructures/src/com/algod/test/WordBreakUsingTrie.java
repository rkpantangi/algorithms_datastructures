package com.algod.test;

import com.algod.util.TrieNode;

/**
 * Print all the combinations in which a sentence can be split, given a set of strings in the dictionary in the form of a trie datastructure.
 * Also print the minimum number of splits needed to split the sentence.
 *
 */
public class WordBreakUsingTrie {

	public static void main(String[] args) {
		// example 1
		TrieNode n = new TrieNode(null);
	    		 
		n.insertWord("Cat");
		n.insertWord("Mat");
		n.insertWord("Ca");
		n.insertWord("tM");
		n.insertWord("at");
		n.insertWord("C");
		n.insertWord("Dog");
		n.insertWord("og");
		n.insertWord("Do");
		
		System.out.println(wordBreak(n, "CatMat", "", 0));
		
		// example 2
		n = new TrieNode(null);
		n.insertWord("this");
		n.insertWord("th");
		n.insertWord("is");
		n.insertWord("famous");
		n.insertWord("Word");
		n.insertWord("break");
		n.insertWord("b");
		n.insertWord("r");
		n.insertWord("e");
		n.insertWord("a");
		n.insertWord("k");
		n.insertWord("br");
		n.insertWord("bre");
		n.insertWord("brea");
		n.insertWord("ak");
		n.insertWord("problem");

		System.out.println(wordBreak(n, "Wordbreakproblem", "", 0));		

		// example 3
		n = new TrieNode(null);
		n.insertWord("C");
		n.insertWord("a");
		n.insertWord("Ca");

		System.out.println(wordBreak(n, "Ca", "", 0));		

		// example 4
		n = new TrieNode(null);
		n.insertWord("Cat");

		System.out.println(wordBreak(n, "Cat", "", 0));		

		// example 5
		n = new TrieNode(null);
		n.insertWord("C");
		n.insertWord("a");
		n.insertWord("Ca");

		System.out.println(wordBreak(n, "Dog", "", 0));		
	}
	
	private static int wordBreak(TrieNode n, String s, String output, int sc) {
		if ("".equals(s)) {
			System.out.println(output);
			return -1;
		}
		int minsc=Integer.MAX_VALUE;
		TrieNode running = n;
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			// walk Trie
			TrieNode child = running.getChild(c);
			if (child != null) {
				String substr = null;
				if (child.isWord()) {
					substr = s.substring(0, i+1);
					minsc = Math.min(minsc, 1 + wordBreak(n, s.substring(i+1), output + " " + substr, sc));
				}
				running = child;
			}
		}
		return minsc;
	}

}
