package leetcode.challenge;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 *
 * https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumber2 {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < 32; ++i) {
      int bitSum = 0;
      for (int j = 0; j < nums.length; ++j) {
        bitSum += (nums[j] >> i) & 1;
      }

      result |= (bitSum % 3) << i;
    }

    return result;
  }
}
