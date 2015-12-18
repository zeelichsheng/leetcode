package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements
 * to the right of nums[i].
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class SmallerNumberAfterSelf {

  /**
   * Counts the number of elements to the right of and smaller than the current element.
   * 
   * @param nums
   * @return
   */
  public List<Integer> countSmaller(int[] nums) {
    int[] indexes = new int[nums.length];
    int[] count = new int[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      indexes[i] = i;
    }

    mergeSort(nums, indexes, count, 0, nums.length - 1);

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < count.length; ++i) {
      result.add(count[i]);
    }

    return result;
  }

  private void mergeSort(int[] nums, int[] indexes, int[] count, int start, int end) {
    if (start >= end) {
      return;
    }

    int mid = (start + end) / 2;
    mergeSort(nums, indexes, count, start, mid);
    mergeSort(nums, indexes, count, mid + 1, end);

    int l = start;
    int r = mid + 1;
    int i = 0;
    int[] sortedIndexes = new int[end - start + 1];
    int rightCount = 0;

    while (l <= mid && r <= end) {
      if (nums[indexes[r]] < nums[indexes[l]]) {
        sortedIndexes[i] = indexes[r];
        ++rightCount;
        ++r;
      } else {
        sortedIndexes[i] = indexes[l];
        count[indexes[l]] += rightCount;
        ++l;
      }

      ++i;
    }

    while (l <= mid) {
      sortedIndexes[i] = indexes[l];
      count[indexes[l]] += rightCount;
      ++l;
      ++i;
    }

    while (r <= end) {
      sortedIndexes[i] = indexes[r];
      ++r;
      ++i;
    }

    for (int t = start; t <= end; ++t) {
      indexes[t] = sortedIndexes[t - start];
    }
  }
}
