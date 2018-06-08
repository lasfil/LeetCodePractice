package com.zinkirin;
/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 */
public class BestTimeStock {
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int maxProfit = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - min);
		}

		return maxProfit;
	}
	//这种解法超时
	/*public int maxProfit(int[] prices) {
    int maxProfit = 0;
    
    for (int i = 0; i < prices.length - 1; i++) {
        for (int j = prices.length-1; j > i; j--) {
            maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
        }
    }
    
    return maxProfit;
	}*/

}
