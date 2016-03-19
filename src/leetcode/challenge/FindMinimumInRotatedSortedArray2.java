package leetcode.challenge;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * The array may contain duplicates.
 * 
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArray2 {
  public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    
    while (start < end) {      
      int mid = (start + end) / 2;
      if (nums[mid] > nums[end]) {
        start = mid + 1;
      } else if (nums[mid] < nums[end]) {
        end = mid;
      } else {
        --end;
      }
    }
    
    return nums[start];
  }
}
