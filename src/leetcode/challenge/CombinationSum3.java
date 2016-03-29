package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 *
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSum3 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<Integer> cache = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    helper(k, 0, 1, n, cache, result);
    return result;
  }

  private void helper(int k, int sum, int start, int n, List<Integer> cache, List<List<Integer>> result) {
    if (k == 0 && sum == n) {
      result.add(new ArrayList<>(cache));
    } else if (k > 0 && sum < n) {
      for (int i = start; i <= 9; ++i) {
        cache.add(i);
        helper(k - 1, sum + i, i + 1, n, cache, result);
        cache.remove(cache.size() - 1);
      }
    }
  }
}
