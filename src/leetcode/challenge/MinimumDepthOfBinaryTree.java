package leetcode.challenge;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along
 * the shortest path from the root node down to the nearest leaf node.
 * 
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
  private int result = Integer.MAX_VALUE;
  
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    helper(root, 1);
    return result;
  }
  
  private void helper(TreeNode root, int currDepth) {
    if (root.left == null && root.right == null) {
      if (currDepth < result) {
        result = currDepth;
      }
      return;
    }
    
    if (root.left != null) {
      helper(root.left, currDepth + 1);
    }
    
    if (root.right != null) {
      helper(root.right, currDepth + 1);
    }
  }
}
