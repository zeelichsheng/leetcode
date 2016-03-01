package leetcode.challenge;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * 
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchForInsertPosition {
  public int searchInsert(int[] nums, int target) {
    return searchInsert(nums, 0, nums.length - 1, target);
  }
  
  private int searchInsert(int[] nums, int start, int end, int target) {
    if (start > end) {
      return start;
    }
    
    int mid = (start + end) / 2;
    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] > target) {
      return searchInsert(nums, start, mid - 1, target);
    } else {
      return searchInsert(nums, mid + 1, end, target);
    }
  }
}
