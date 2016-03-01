package leetcode.challenge;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    boolean[] hash = new boolean[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > 0 && nums[i] <= nums.length) {
        hash[nums[i] - 1] = true;
      }
    }

    for (int i = 0; i < nums.length; ++i) {
      if (!hash[i]) {
        return i + 1;
      }
    }

    return nums.length + 1;
  }
}
