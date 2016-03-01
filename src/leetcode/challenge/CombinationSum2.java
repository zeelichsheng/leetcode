package leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T. Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 *
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    combinationSum(candidates, target, 0, combination, result);
    return result;
  }

  private void combinationSum(int[] candidates, int target, int index,
                              List<Integer> combination, List<List<Integer>> result) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      result.add(new ArrayList<>(combination));
    } else {
      for (int i = index; i < candidates.length; ++i) {
        if (i == index || candidates[i] != candidates[i - 1]) {
          combination.add(candidates[i]);
          combinationSum(candidates, target - candidates[i], i + 1, combination, result);
          combination.remove(combination.size() - 1);
        }
      }
    }
  }
}
