package com.hungerfool.stock;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
	public static void maxProfit() {
		System.out.println(maxProfit(new int[] { 3, 7, 4, 6, 100,101 }, 2));
	}

	public static int maxProfit(int[] prices, int fee) {
		int profit = 0;
		int maxCash = 0 - prices[0];
		System.out.println("price: " + prices[0] + " profit: " + profit + " maxCash: " + maxCash);
		for (int i = 1; i < prices.length; i++) {
			maxCash = Math.max(maxCash, profit - prices[i]);
			profit = Math.max(profit, prices[i] + maxCash);
			
			System.out.println("price: " + prices[i] + " profit: " + profit + " maxCash: " + maxCash);
		}

		return profit;
	}
}
