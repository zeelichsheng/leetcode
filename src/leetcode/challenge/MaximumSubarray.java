package leetcode.challenge;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];

      if (sum > maxSum) {
        maxSum = sum;
      }

      if (sum < 0) {
        sum = 0;
      }
    }

    return maxSum;
  }
}
