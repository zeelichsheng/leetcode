package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where
 * each path's sum equals the given sum.
 * 
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSum2 {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> cache = new Stack<>();
    if (root != null) {
      helper(root, sum, 0, cache, result);
    }
    
    return result;
  }
  
  private void helper(TreeNode root, int target, int currSum,
      Stack<Integer> cache, List<List<Integer>> result) {
    cache.push(root.val);
    
    if (root.left == null && root.right == null) {
      if (currSum + root.val == target) {
        result.add(new ArrayList<>(cache));
        cache.pop();
        return;        
      }
    }
        
    if (root.left != null) {
      helper(root.left, target, currSum + root.val, cache, result);
    }
    
    if (root.right != null) {
      helper(root.right, target, currSum + root.val, cache, result);
    }
    
    cache.pop();
  }
}
