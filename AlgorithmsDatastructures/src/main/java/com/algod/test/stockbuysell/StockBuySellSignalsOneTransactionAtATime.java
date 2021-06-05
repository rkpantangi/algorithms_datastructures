package com.algod.test.stockbuysell;

/**
 * Generate buy/sell signals that generate maximum profit
 * One transaction at a time, unlimited transactions allowed, assume unit amount bought or sold.
 */
public class StockBuySellSignalsOneTransactionAtATime {

	public static void main(String [] args) {
		int [] arr = new int[] {20, 30, 50, 100, 100, 80, 70, 120, 130, 70, 60, 100, 125, 10, 20, 10, 5, 7};
		int profit = 0;

		int buyIndex = 0;
		for (int i=1;i<arr.length;i++) {
			if (arr[i-1] >= arr[i]) { // [3] > [4]
				if (buyIndex != (i-1)) {
					profit += (arr[i-1] - arr[buyIndex]);
					System.out.println("Buy at " + arr[buyIndex] + " , sell at " + arr[i-1]);
				}
				buyIndex = i;
			}
		}
		if (buyIndex != (arr.length-1)) {
			profit += (arr[arr.length - 1] - arr[buyIndex]);
			System.out.println("Buy at " + arr[buyIndex] + " , sell at " + arr[arr.length-1]);
		}

		System.out.println("profit : " + profit);
	}	
}
