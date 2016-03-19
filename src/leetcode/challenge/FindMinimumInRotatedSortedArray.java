package leetcode.challenge;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    
    while (start < end) {
      if (end - start == 1) {
        return Math.min(nums[start], nums[end]);
      }
      
      int mid = (start + end) / 2;
      if (nums[mid] < nums[end]) {
        end = mid;
      } else {
        start = mid;
      }
    }
    
    return nums[start];
  }
}
