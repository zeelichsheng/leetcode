package leetcode.challenge;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] >= 0) {
        max = Math.max(nums[i] * max, nums[i]);
        min = Math.min(nums[i] * min, nums[i]);
      } else {
        int tmp = max;
        max = Math.max(nums[i] * min, nums[i]);
        min = Math.min(nums[i] * tmp, nums[i]);
      }

      result = Math.max(max, result);
    }

    return result;
  }
}
