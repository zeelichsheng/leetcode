package leetcode.challenge;

/**
 * Find the kth largest element in an unsorted array. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestInArray {
  public int findKthLargest(int[] nums, int k) {
    return find(nums, 0, nums.length - 1, k);
  }

  private int find(int[] nums, int start, int end, int k) {
    int pivot = nums[start];
    int i = start;
    int j = end;

    while (i < j) {
      while (i < j && nums[j] <= pivot) {
        --j;
      }

      nums[i] = nums[j];

      while (i < j && nums[i] >= pivot) {
        ++i;
      }

      nums[j] = nums[i];
    }

    nums[i] = pivot;
    if (i == k - 1) {
      return nums[i];
    } else if (i > k - 1) {
      return find(nums, 0, i - 1, k);
    } else {
      return find(nums, i + 1, nums.length - 1, k);
    }
  }
}
