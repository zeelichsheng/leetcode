package leetcode.challenge;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next
 * greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
  public void nextPermutation(int[] nums) {
    int i = nums.length - 1;
    int j = nums.length - 1;
    
    while (i > 0 && nums[i - 1] >= nums[i]) {
      --i;
    }
    
    if (i == 0) {
      reverse(nums, 0, nums.length - 1);
      return;
    }
    
    while (j >= 0 && nums[j] <= nums[i - 1]) {
      --j;
    }
    
    swap(nums, i - 1, j);
    reverse(nums, i, nums.length - 1);
  }
  
  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      ++start;
      --end;
    }
  }
  
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
