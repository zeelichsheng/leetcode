package leetcode.challenge;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that
 * the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly
 * one solution.
 * 
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    
    int result = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; ++i) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (Math.abs(sum - target) < Math.abs(result - target)) {
          result = sum;
        }
        
        if (sum < target) {
          ++j;
        } else {
          --k;
        }
      }
    }
    
    return result;
  }
}
