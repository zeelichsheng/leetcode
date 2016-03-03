package leetcode.challenge;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of
 * the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
  public void sortColors(int[] nums) {
    int red = -1;
    int white = -1;
    int blue = -1;

    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 0) {
        nums[++blue] = 2;
        nums[++white] = 1;
        nums[++red] = 0;
      } else if (nums[i] == 1) {
        nums[++blue] = 2;
        nums[++white] = 1;
      } else {
        nums[++blue] = 2;
      }
    }
  }
}
