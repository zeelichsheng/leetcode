package leetcode.challenge;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear
 * only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedList {
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n == 0 || n == 1) {
      return n;
    }

    int i = 0;
    int j = i + 1;
    while (j < n) {
      if (nums[i] != nums[j]) {
        ++i;
        nums[i] = nums[j];
      }

      ++j;
    }

    return i + 1;
  }
}
