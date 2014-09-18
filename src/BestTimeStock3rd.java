/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 */
public class BestTimeStock3rd {
	public int maxProfit(int[] prices) {
		int n = prices.length;

		if (n < 2) {
			return 0;
		} else if (n == 2) {
			return Math.max(0, prices[1] - prices[0]);
		}

		int[] lSubMaxProfit = new int[n];
		int[] rSubMaxProfit = new int[n];

		int min = prices[0];
		lSubMaxProfit[0] = 0;
		for (int i = 1; i < n; i++) {
			min = Math.min(min, prices[i]);
			lSubMaxProfit[i] = Math.max(prices[i] - min, lSubMaxProfit[i - 1]);
		}

		int max = 0;
		rSubMaxProfit[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			max = Math.max(max, prices[i + 1]);
			rSubMaxProfit[i] = Math.max(max - prices[i + 1],
					rSubMaxProfit[i + 1]);
		}

		int maxProfit = lSubMaxProfit[0] + rSubMaxProfit[0];

		for (int i = 1; i < n; i++) {
			maxProfit = Math
					.max(maxProfit, rSubMaxProfit[i] + lSubMaxProfit[i]);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 4, 5, 2, 9, 10, 7, 25, 4, 15, 27, 3, 8 };
		System.out.println(new BestTimeStock3rd().maxProfit(prices));
	}
}
