package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in
 * C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    combinationSum(candidates, target, 0, 0, combination, result);
    return result;
  }
  
  private void combinationSum(int[] candidates, int target, int index, int sum,
      List<Integer> combination, List<List<Integer>> result) {
    for (int i = index; i < candidates.length; ++i) {
      sum += candidates[i];
      combination.add(candidates[i]);
      
      if (sum < target) {
        combinationSum(candidates, target, i, sum, combination, result);
      } else if (sum == target) {
        result.add(new ArrayList<>(combination));
      } else {        
        sum -= candidates[i];
        combination.remove(combination.size() - 1);
        break;
      }
      sum -= candidates[i];
      combination.remove(combination.size() - 1);
    }
  }
}
