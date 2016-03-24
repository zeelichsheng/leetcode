package leetcode.challenge;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of
 * which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    int i = 0;
    int len = 0;
    int sum = 0;

    for (int j = 0; j < nums.length; ++j) {
      sum += nums[j];

      while (sum - nums[i] >= s) {
        sum -= nums[i];
        ++i;
      }

      if (sum >= s) {
        len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
      }
    }

    return len;
  }
}
