package com.algod.test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array with stock prices, find the Maximum profit by buying and selling in two ways
 * 1. Buy and sell only once - so just find two points in that sequence wherever it is best to buy and sell
 * 2. Buy and sell multiple times - so if the price dips at any point, you can sell and buy again.
 */
public class MaxProfit {

	public static void main(String[] args) {
		int [] input = new int[] {1,3,8,2,18};
		maxProfit_Buy_Multiple_Times(input);
		System.out.println("---------------------------------");
		input = new int[] {1,3,8,2,4};
		maxProfit_Buy_Multiple_Times(input);
		System.out.println("---------------------------------");
		input = new int[] {1,8,2,18,4};
		maxProfit_Buy_Multiple_Times(input);
		System.out.println("---------------------------------");
		input = new int[] {1,2,3,4,5};
		maxProfit_Buy_Multiple_Times(input);
		System.out.println("---------------------------------");
		input = new int[] {1, 1, 1000, 1, 1, 100000};
		maxProfit_Buy_Multiple_Times(input);
		System.out.println("---------------------------------");
		input = new int[] {100, 180, 260, 310, 40, 535, 695};
		maxProfit_Buy_Multiple_Times(input);

		System.out.println("######################################");
		input = new int[] {10, 22, 5, 75, 65, 80};
		maxProfit_Buy_At_Most_K_Times(input, 2);

		System.out.println("######################################");

		input = new int[] {1,3,8,2,18};
		maxProfit_Buy_Only_Once(input);

		input = new int[] {5,18,1,2,3};
		maxProfit_Buy_Only_Once(input);

		input = new int[] {1,18,5,4,10};
		maxProfit_Buy_Only_Once(input);

	}
	
	public static void maxProfit_Buy_Multiple_Times(int [] input) {
		int currentBuy=0;
		int currentSell=-1;
		int totalProfit = 0;
		for (int i=1;i<input.length;i++) {
			if (input[i] < input[i-1]) {
				if (currentSell >= 0) {
					int currentProfit = (input[currentSell] - input[currentBuy]);
					totalProfit += currentProfit;
					System.out.println("Profit - " + currentProfit + ", buy at - " + currentBuy +
											   ", sell at " + currentSell);
					currentSell = -1;
				}
				currentBuy=i;
			} else if(input[i] > input[i-1]) {
				currentSell = i;
			}
		}
		if (currentSell > 0) {
			int currentProfit = (input[currentSell] - input[currentBuy]);
			totalProfit += currentProfit;
			System.out.println("Profit - " + currentProfit + ", buy at - " + currentBuy +
									   ", sell at " + currentSell);
		}
		System.out.println("Total Profit - " + totalProfit);
	}

	static class Data {
		int buy;
		int sell;
		int profit;

		public Data(int buy, int sell, int profit) {
			this.buy = buy;
			this.sell = sell;
			this.profit = profit;
		}

		int getProfit() {
			return profit;
		}
	}

	public static void maxProfit_Buy_At_Most_K_Times(int [] input, int k) {
		int currentBuy=0;
		int currentSell=-1;

		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(Data::getProfit));
		for (int i=1;i<input.length;i++) {
			if (input[i] < input[i-1]) {
				if (currentSell >= 0) {
					captureProfit(currentBuy, currentSell, pq, k, input);
					currentSell = -1;
				}
				currentBuy=i;
			} else if(input[i] > input[i-1]) {
				currentSell = i;
				if (i == input.length - 1) {
					captureProfit(currentBuy, currentSell, pq, k, input);
				}
			}
		}

		int totalProfit = 0;
		while(pq.size() > 0) {
			Data d = pq.poll();
			System.out.println("Profit - " + d.profit + ", buy at - " + input[d.buy] + ", sell at " + input[d.sell]);
			totalProfit += d.profit;
		}
		System.out.println("Total Profit - " + totalProfit);
	}

	private static void captureProfit(int currentBuy, int currentSell, PriorityQueue<Data> pq, int k, int [] input) {
		int currentProfit = (input[currentSell] - input[currentBuy]);
		if (pq.size() < k || (pq.size() > 0 && pq.peek().profit < currentProfit)) {
			Data data = new Data(currentBuy, currentSell, currentProfit);
			pq.add(data);
			if (pq.size() > k) {
				pq.poll();
			}
		}
	}

	public static void maxProfit_Buy_Only_Once(int [] input) {
		int bestMax=-1;
		int bestMin=0;
		int bestProfit=0;
		int currentMin=0;

		for (int i=1;i<input.length;i++) {
			if (input[i] > input[i-1]) {
				int currentProfit = input[i] - input[currentMin];
				if (bestProfit < currentProfit) {
					bestProfit = currentProfit;
					bestMin = currentMin;
					bestMax = i;
				}
			} else if (input[i] < input[i-1]) {
				if (input[i] < input[bestMin]) {
					currentMin = i;
				}
			}
		}

		System.out.println("Best Min - " + bestMin + ", best max - " + bestMax + ", best profit - " + bestProfit);
	}

}
