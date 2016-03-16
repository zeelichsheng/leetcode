package leetcode.challenge;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * https://leetcode.com/problems/candy/
 */
public class Candy {
  public int getCandies(int[] ratings) {
    if (ratings.length < 2) {
      return ratings.length;
    }

    // Each child has at least one candy
    int[] dp = new int[ratings.length];
    for (int i = 0; i < ratings.length; ++i) {
      dp[i] = 1;
    }

    // From left to right, guarantees that current child has more candies than previous child if
    // current rating is higher
    for (int i = 1; i < ratings.length; ++i) {
      if (ratings[i] > ratings[i - 1]) {
        dp[i] = dp[i - 1] + 1;
      }
    }

    // From right to left, guarantees that if current child has higher rating than next child and
    // current candy is less than next candy, current candy should be higher than next candy
    for (int i = ratings.length - 2; i >= 0; --i) {
      if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) {
        dp[i] = dp[i + 1] + 1;
      }
    }

    int result = 0;
    for (int i = 0; i < dp.length; ++i) {
      result += dp[i];
    }

    return result;
  }
}
