package com.algod.test;

public class RabinKarpSubstringSearch {

	public static void main(String[] args) {
		String ms = "test string";
		String ss = "str";
		
		int index = robinKarpSearch(ms, ss);
		System.out.println("index - " + index);
	}

	private static int robinKarpSearch(String ms, String ss) {
		if (ss == null) return -1;
		if (ss.length() == 1) {
			// becomes a linear search
			return ms.indexOf(ss);
		}
		
		int searchHash = initialHash(ss);
		
		int hash = initialHash(ms.substring(0, ss.length()));
		if (hash == searchHash) return 0;
		for (int i=1;i<=(ms.length() - ss.length());i++) {
			hash = rehash(hash, i+ss.length()-1, i-1, ms, ss);
			if (hash == searchHash) return i;
		}
		return -1;
	}

	private static int rehash(int hash, int add, int remove, String ms, String ss) {
		hash = (hash - ms.charAt(remove))/3 + (int)Math.pow(3, ss.length()-1) * ms.charAt(add);
		return hash;
	}

	private static int initialHash(String ss) {
		int hash = 0;
		for (int i=0;i<ss.length();i++) {
			hash += (Math.pow(3, i) * ss.charAt(i));
		}
		return hash;
	}
	
	

}
