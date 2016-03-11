package leetcode.challenge;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStock3 {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }

    int[] forward = new int[prices.length];
    int[] backward = new int[prices.length];

    forward[0] = 0;
    int minBuy = prices[0];
    for (int i = 1; i < prices.length; ++i) {
      forward[i] = Math.max(forward[i - 1], prices[i] - minBuy);
      minBuy = Math.min(minBuy, prices[i]);
    }

    backward[0] = 0;
    int maxSell = prices[prices.length - 1];
    for (int i = prices.length - 2; i >= 0; --i) {
      backward[i] = Math.max(backward[i + 1], maxSell - prices[i]);
      maxSell = Math.max(maxSell, prices[i]);
    }

    int profit = 0;
    for (int i = 0; i < prices.length; ++i) {
      profit = Math.max(profit, forward[i] + backward[i]);
    }

    return profit;
  }
}
