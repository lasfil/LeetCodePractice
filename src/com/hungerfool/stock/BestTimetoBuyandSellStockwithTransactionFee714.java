package com.hungerfool.stock;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
	public static void maxProfit() {
		System.out.println(maxProfit(new int[] { 2, 1, 2, 4, 3, 7, 3, 5, 8, 2, 34, 6 }, 2));
	}

	public static int maxProfit(int[] prices, int fee) {
		int cash = 0;
		int stock = 0 - prices[0];
		for (int i = 1; i < prices.length; i++) {
			cash = Math.max(cash, prices[i] + stock - fee);
			stock = Math.max(stock, cash - prices[i]);
		}

		return cash;
	}
}
