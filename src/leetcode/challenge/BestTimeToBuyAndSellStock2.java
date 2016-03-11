package leetcode.challenge;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as
 * you like (ie, buy one and sell one share of the stock multiple times). However, you may
 * not engage in multiple transactions at the same time (ie, you must sell the stock before
 * you buy again).
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStock2 {
  public int maxProfit(int[] prices) {
    int minPrice = -1;
    int totalProfit = 0;

    for (int i = 0; i < prices.length - 1; ++i) {
      if (prices[i] >= prices[i + 1]) {
        if (minPrice != -1) {
          totalProfit += prices[i] - minPrice;
        }
        minPrice = -1;
        continue;
      }

      if (minPrice == -1) {
        minPrice = prices[i];
      }
    }

    if (minPrice != -1 && prices[prices.length - 1] > minPrice) {
      totalProfit += prices[prices.length - 1] - minPrice;
    }

    return totalProfit;
  }
}
