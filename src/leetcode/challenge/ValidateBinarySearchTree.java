package leetcode.challenge;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
  private static final Triple FalseTriple = new Triple(false, null, null);
  
  public boolean isValidBST(TreeNode root) {
    Triple t = helper(root);
    if (t == null) {
      return true;
    }
    
    return t.isValid;
  }
  
  private Triple helper(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    Triple leftTriple = helper(root.left);
    Triple rightTriple = helper(root.right);
    
    if (leftTriple == null && rightTriple == null) {
      return new Triple(true, root.val, root.val);
    }
    
    if (leftTriple == null) {
      if (!rightTriple.isValid) {
        return FalseTriple;
      }
      
      if (root.val >= rightTriple.min) {
        return FalseTriple;
      }
      
      return new Triple(true, root.val, rightTriple.max);
    }
    
    if (rightTriple == null) {
      if (!leftTriple.isValid) {
        return FalseTriple;
      }
      
      if (root.val <= leftTriple.max) {
        return FalseTriple;
      }
      
      return new Triple(true, leftTriple.min, root.val);
    }
    
    if (!leftTriple.isValid || !rightTriple.isValid) {
      return FalseTriple;
    }
    
    if (leftTriple.max >= rightTriple.min) {
      return FalseTriple;
    }
    
    if (root.val <= leftTriple.max || root.val >= rightTriple.min) {
      return FalseTriple;
    }
    
    return new Triple(true, leftTriple.min, rightTriple.max);
  }
  
  private static class Triple {
    public boolean isValid;
    public Integer max;
    public Integer min;
    
    public Triple(boolean isValid, Integer min, Integer max) {
      this.isValid = isValid;
      this.min = min;
      this.max = max;
    }
  }
}
