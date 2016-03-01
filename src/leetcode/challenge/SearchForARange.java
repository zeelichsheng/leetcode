package leetcode.challenge;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * https://leetcode.com/problems/search-for-a-range/
 */
public class SearchForARange {
  private static final int[] invalidRange = new int[] { -1, -1 };
  
  public int[] searchRange(int[] nums, int target) {
    return searchRange(nums, 0, nums.length - 1, target);
  }
  
  public int[] searchRange(int[] nums, int start, int end, int target) {
    if (start > end) {
      return invalidRange;
    }
    
    int mid = (start + end) / 2;
    if (target < nums[mid]) {
      return searchRange(nums, start, mid - 1, target);
    } else if (target > nums[mid]) {
      return searchRange(nums, mid + 1, end, target);
    } else {
      
      int[] leftRange = searchRange(nums, start, mid - 1, target);
      int[] rightRange = searchRange(nums, mid + 1, end, target);
      
      if (leftRange == invalidRange && rightRange == invalidRange) {
        return new int[] { mid, mid };
      }
      
      if (leftRange == invalidRange) {
        return new int[] { mid, rightRange[1] };
      }
      
      if (rightRange == invalidRange) {
        return new int [] { leftRange[0], mid };
      }
      
      return new int[] { leftRange[0], rightRange[1] };
    }
  }
}
