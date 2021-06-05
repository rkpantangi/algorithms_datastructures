package com.algod.test.stockbuysell;

/**
 * Generate buy/sell signals that generate maximum profit
 * One transaction at a time, unlimited transactions allowed, assume unit amount bought or sold.
 */
public class StockBuySellSignalsOneTransactionAtATime1 {

/*	Buy at 20 , sell at 100
	Buy at 70 , sell at 130
	Buy at 60 , sell at 125
	Buy at 10 , sell at 20
	Buy at 5 , sell at 7
	profit : 217*/
	public static void main(String [] args) {
		int [] arr = new int[] {20, 30, 50, 100, 100, 80, 70, 120, 130, 70, 60, 100, 125, 10, 20, 10, 5, 7};
		int profit = 0;

		int buy=0;
		int sell=0;

		for (int price : arr) {
			if (buy == 0) {
				buy = price;
				continue;
			}
			if (price < buy && sell == 0) {
				buy = price;
			} else if (price > sell) {
				sell = price;
			} else {
				System.out.println("buy at " + buy + ", sell at - " + sell);
				profit += (sell - buy);
				sell = 0;
				buy = price;
			}
		}
		if (sell > 0) profit += (sell - buy);
		System.out.println("profit : " + profit);
	}	
}
