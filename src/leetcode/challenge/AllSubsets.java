package leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 * https://leetcode.com/problems/subsets/
 */
public class AllSubsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int k = 0; k <= nums.length; ++k) {
      Stack<Integer> st = new Stack<>();
      getSubset(nums, k, 0, st, result);
    }

    return result;
  }

  private void getSubset(int[] nums, int k, int t, Stack<Integer> st, List<List<Integer>> result) {
    if (k == 0) {
      result.add(new ArrayList<>(st));
      return;
    }

    for (int i = t; i < nums.length; ++i) {
      st.push(nums[i]);
      getSubset(nums, k - 1, i + 1, st, result);
      st.pop();
    }
  }
}
