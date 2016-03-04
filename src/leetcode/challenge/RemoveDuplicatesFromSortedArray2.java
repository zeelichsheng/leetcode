package leetcode.challenge;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArray2 {
  private static final int ALLOWED_DUPLICATES = 2;

  public int removeDuplicates(int[] nums) {
    int i = 0;
    int j = i + 1;
    int allowed = ALLOWED_DUPLICATES;

    while (j < nums.length) {
      if (nums[i] == nums[j]) {
        if (allowed > 1) {
          ++i;
          nums[i] = nums[j];
          --allowed;
        }
      } else {
        ++i;
        nums[i] = nums[j];
        allowed = ALLOWED_DUPLICATES;
      }

      ++j;
    }

    return i + 1;
  }
}
