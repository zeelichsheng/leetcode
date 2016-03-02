package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> permutation = new Stack<>();
    Set<Integer> hash = new HashSet<>();
    
    permute(nums, hash, permutation, result);
    return result;
  }
  
  private void permute(int[] nums, Set<Integer> hash, Stack<Integer> permutation, List<List<Integer>> result) {
    if (hash.size() == nums.length) {    
      result.add(new ArrayList<>(permutation));
      return;
    }
    
    for (int i = 0; i < nums.length; ++i) {
      if (!hash.contains(i)) {
        hash.add(i);
        permutation.push(nums[i]);
        permute(nums, hash, permutation, result);
        permutation.pop();
        hash.remove(i);
      }
    }
  }
}
