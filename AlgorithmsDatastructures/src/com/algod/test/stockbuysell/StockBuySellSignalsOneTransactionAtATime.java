package com.algod.test.stockbuysell;

/**
 * Generate buy/sell signals that generate maximum profit
 * One transaction at a time, unlimited transactions allowed, assume unit amount bought or sold.
 */
public class StockBuySellSignalsOneTransactionAtATime {

	public static void main(String [] args) {
		int [] arr = new int[] {100, 80, 120, 130, 70, 60, 100, 125};
		
		int buy = arr[0];
		int buyindex = 0;
		int profit = 0;
		for (int i=1;i<arr.length;i++) {
			if (i == arr.length-1) {
				System.out.println("Buy at : " + buy + ", sell at : " + arr[i]);
				profit += (arr[i] - buy);
			} else if (arr[i-1] > arr[i]) {
				if (buyindex < i-1) {
					System.out.println("Buy at : " + buy + ", sell at : " + arr[i-1]);
					profit += (arr[i-1] - buy);
				}
				buy = arr[i];
				buyindex = i;
			}
		}

		System.out.println("profit : " + profit);
	}	
}
