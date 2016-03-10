package leetcode.challenge;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined
 * as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * 
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
  private static final Pair FalsePair = new Pair(false, 0);
  
  public boolean isBalanced(TreeNode root) {
    return helper(root).isBalanced;
  }
  
  private Pair helper(TreeNode root) {
    if (root == null) {
      return new Pair(true, 0);
    }
    
    Pair leftPair = helper(root.left);
    Pair rightPair = helper(root.right);
    if (!leftPair.isBalanced || !rightPair.isBalanced) {
      return FalsePair;
    }
    
    if (Math.abs(leftPair.depth - rightPair.depth) > 1) {
      return FalsePair;
    }
    
    return new Pair(true, Math.max(leftPair.depth, rightPair.depth) + 1);
  }
  
  private static class Pair {
    public boolean isBalanced;
    public int depth;
    
    public Pair(boolean isBalanced, int depth) {
      this.isBalanced = isBalanced;
      this.depth = depth;
    }
  }
}
