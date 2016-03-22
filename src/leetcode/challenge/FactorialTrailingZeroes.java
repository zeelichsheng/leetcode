package leetcode.challenge;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    int k = 5;
    int result = 0;
    int upper_limit = Integer.MAX_VALUE / 5;
    while (n >= k) {
      result += n / k;
      if (k > upper_limit) {
        break;
      }

      k *= 5;
    }

    return result;
  }
}
