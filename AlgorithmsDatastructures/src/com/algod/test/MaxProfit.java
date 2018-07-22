package com.algod.test;

public class MaxProfit {

	public static void main(String[] args) {
		int [] input = new int[] {1,3,8,2,18};
		maxProfit(input);
		input = new int[] {1,3,8,2,4};
		maxProfit(input);
		input = new int[] {1,8,2,18,4};
		maxProfit(input);
		input = new int[] {1,2,3,4,5};
		maxProfit(input);
		input = new int[] {1, 1, 1000, 1, 1, 100000};
		maxProfit(input);
		input = new int[] {100, 180, 260, 310, 40, 535, 695};
		maxProfit(input);
	}
	
	public static void maxProfit(int [] input) {
		int currentMin=0;
		int bestMin=0;
		int bestMax=0;
		int maxProfit = 0;
		int currentProfit = 0;
		for (int i=1;i<input.length;i++) {
			if (input[i] <= input[i-1]) {
				currentMin=i;
			}
			
			currentProfit = input[i] - input[currentMin];
			if (currentProfit > maxProfit) {
				maxProfit = currentProfit;
				bestMin=currentMin;
				bestMax=i;
			}
		}
		System.out.println(maxProfit + ", " + bestMin + ", " + bestMax);
	}
}
