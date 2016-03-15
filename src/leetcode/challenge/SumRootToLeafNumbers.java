package leetcode.challenge;

import leetcode.model.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * Find the total sum of all root-to-leaf numbers.
 * 
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
  private int sum = 0;
  
  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    helper(root, 0);
    
    return sum;
  }
  
  private void helper(TreeNode root, int pathSum) {
    pathSum = pathSum * 10 + root.val;
    
    if (root.left == null && root.right == null) {
      sum += pathSum;
      return;
    }
    
    if (root.left != null) {
      helper(root.left, pathSum);
    }
    
    if (root.right != null) {
      helper(root.right, pathSum);
    }
  }
}
