package leetcode.challenge;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArray2 {
  public boolean search(int[] nums, int target) {
    return search(nums, 0, nums.length - 1, target);
  }

  private boolean search(int[] nums, int start, int end, int target) {
    if (start > end) {
      return false;
    }

    while (start <= end) {
      int mid = (start + end) / 2;

      if (nums[mid] == target) {
        return true;
      }

      if (nums[start] < nums[mid]) {
        if (nums[start] <= target && target < nums[mid]) {
          return search(nums, start, mid - 1, target);
        } else {
          return search(nums, mid + 1, end, target);
        }
      } else if (nums[start] > nums[mid]) {
        if (nums[mid] < target && target <= nums[end]) {
          return search(nums, mid + 1, end, target);
        } else {
          return search(nums, start, mid - 1, target);
        }
      } else {
        ++start;
      }
    }

    return false;
  }
}
