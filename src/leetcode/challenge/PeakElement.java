package leetcode.challenge;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * https://leetcode.com/problems/find-peak-element/
 */
public class PeakElement {
  public int findPeakElement(int[] nums) {
    if (nums.length == 0) {
      return -1;
    }
    
    if (nums.length == 1) {
      return nums[0];
    }
    
    for (int i = 0; i < nums.length; ++i) {
      if (i == 0) {
        if (nums[i] > nums[i + 1]) {
          return i;
        }
      } else if (i == nums.length - 1) {
        if (nums[i] > nums[i - 1]) {
          return i;
        }
      } else {
        if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
          return i;
        }
      }
    }
    
    return -1;
  }
}
