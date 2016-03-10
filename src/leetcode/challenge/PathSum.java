package leetcode.challenge;

import leetcode.model.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 *
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    
    return hasPathSum(root, sum, 0);
  }
  
  private boolean hasPathSum(TreeNode root, int target, int currSum) {
    if (root.left == null && root.right == null) {
      return currSum + root.val == target;
    }
    
    if (root.left != null && hasPathSum(root.left, target, currSum + root.val)) {
      return true;
    }
    
    if (root.right != null && hasPathSum(root.right, target, currSum + root.val)) {
      return true;
    }
    
    return false;
  }
}
