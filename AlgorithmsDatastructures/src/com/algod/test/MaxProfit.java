package com.algod.test;

/**
 * Given an array with stock prices, find the Maximum profit by buying and selling in two ways
 * 1. Buy and sell only once - so just find two points in that sequence wherever it is best to buy and sell
 * 2. Buy and sell multiple times - so if the price dips at any point, you can sell and buy again.
 */
public class MaxProfit {

	public static void main(String[] args) {
		int [] input = new int[] {1,3,8,2,18};
		maxProfit_Buy_Multiple_Times(input);
		input = new int[] {1,3,8,2,4};
		maxProfit_Buy_Multiple_Times(input);
		input = new int[] {1,8,2,18,4};
		maxProfit_Buy_Multiple_Times(input);
		input = new int[] {1,2,3,4,5};
		maxProfit_Buy_Multiple_Times(input);
		input = new int[] {1, 1, 1000, 1, 1, 100000};
		maxProfit_Buy_Multiple_Times(input);
		input = new int[] {100, 180, 260, 310, 40, 535, 695};
		maxProfit_Buy_Multiple_Times(input);
		
		System.out.println("---------------------------------");
		
		input = new int[] {1,3,8,2,18};
		maxProfit_Buy_Only_Once(input);
		input = new int[] {1,3,8,2,4};
		maxProfit_Buy_Only_Once(input);
		input = new int[] {1,8,2,18,4};
		maxProfit_Buy_Only_Once(input);
		input = new int[] {1,2,3,4,5};
		maxProfit_Buy_Only_Once(input);
		input = new int[] {1, 1, 1000, 1, 1, 100000};
		maxProfit_Buy_Only_Once(input);
		input = new int[] {100, 180, 260, 310, 40, 535, 695};
		maxProfit_Buy_Only_Once(input);
	}
	
	public static void maxProfit_Buy_Multiple_Times(int [] input) {
		int currentMin=0;
		int bestMin=0;
		int bestMax=0;
		int maxProfit = 0;
		int currentProfit = 0;
		for (int i=1;i<input.length;i++) {
			if (input[i] <= input[i-1]) {
				currentMin=i;
			} else {			
				currentProfit = input[i] - input[currentMin];
				if (currentProfit > maxProfit) {
					maxProfit = currentProfit;
					bestMin=currentMin;
					bestMax=i;
				}
			}
		}
		System.out.println(maxProfit + ", " + bestMin + ", " + bestMax);
	}
	
	public static void maxProfit_Buy_Only_Once(int [] input) {
		int currentMin=0;
		int bestMax=0;
		int maxProfit = 0;
		int currentProfit = 0;
		for (int i=1;i<input.length;i++) {
			if (input[i] < input[currentMin]) {
				currentMin=i;
			} else {			
				currentProfit = input[i] - input[currentMin];
				if (currentProfit > maxProfit) {
					maxProfit = currentProfit;
					bestMax=i;
				}
			}
		}
		System.out.println(maxProfit + ", " + currentMin + ", " + bestMax);
	}
}
