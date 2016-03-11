package leetcode.challenge;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one
 * share of the stock), design an algorithm to find the maximum profit.
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; ++i) {
      int p = prices[i];

      if (p < minPrice) {
        minPrice = p;
      }

      if (p - minPrice > maxProfit) {
        maxProfit = p - minPrice;
      }
    }

    return maxProfit;
  }
}
