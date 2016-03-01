package leetcode.challenge;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    return search(nums, 0, nums.length - 1, target);
  }

  private int search(int[] nums, int start, int end, int target) {
    if (start > end) {
      return -1;
    }

    int mid = (start + end) / 2;

    if (nums[mid] == target) {
      return mid;
    }

    if (nums[start] <= nums[mid]) {
      if (nums[start] <= target && target < nums[mid]) {
        return search(nums, start, mid - 1, target);
      } else {
        return search(nums, mid + 1, end, target);
      }
    } else {
      if (nums[mid] < target && target <= nums[end]) {
        return search(nums, mid + 1, end, target);
      } else {
        return search(nums, start, mid - 1, target);
      }
    }
  }
}
