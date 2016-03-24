package leetcode.challenge;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of
 * money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting the police.
 *
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int robPrevious = 0;
    int notRobPrevious = 0;
    for (int num : nums) {
      int robCurr = notRobPrevious + num;
      int notRobCurr = Math.max(robPrevious, notRobPrevious);

      robPrevious = robCurr;
      notRobPrevious = notRobCurr;
    }

    return Math.max(robPrevious, notRobPrevious);
  }
}
