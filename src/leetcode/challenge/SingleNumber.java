package leetcode.challenge;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; ++i) {
      result ^= nums[i];
    }

    return result;
  }
}
