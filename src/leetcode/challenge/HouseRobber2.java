package leetcode.challenge;

/**
 * This is an extension of House Robber.
 * After robbing those houses on that street, the thief has found himself a new place for his thievery
 * so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That
 * means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain
 * the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 * https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobber2 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  private int rob(int[] nums, int start, int end) {
    int robPrevious = 0;
    int notRobPrevious = 0;
    for (int i = start; i <= end; ++i) {
      int robCurrent = notRobPrevious + nums[i];
      int notRobCurrent = Math.max(robPrevious, notRobPrevious);

      robPrevious = robCurrent;
      notRobPrevious = notRobCurrent;
    }

    return Math.max(robPrevious, notRobPrevious);
  }
}
