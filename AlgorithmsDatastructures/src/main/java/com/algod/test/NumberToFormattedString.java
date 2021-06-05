package com.algod.test;

public class NumberToFormattedString {

	public static void main(String[] args) {
		
		int num = 1123;
		
		String ret = "";
		int iter=0;
		while(true) {
			int n=0;
			if (iter == 0) {
				n = num%1000;
				num = num / 1000;
			} else {
				n = num%100;
				num = num / 100;
			}
			
			ret = ((num == 0 ? "" : ",") + (n == 0 ? (iter == 0 ? "000" : "00") : n)) + ret;
			iter++;
			if (num == 0) break;
		}
		
		System.out.println(ret);
	}
	
}
