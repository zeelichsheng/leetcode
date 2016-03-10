package leetcode.challenge;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    
    helper(root);
  }
  
  private Pair helper(TreeNode root) {
    if (root.left == null && root.right == null) {
      return new Pair(root, root);
    }
    
    Pair leftPair = root.left != null ? helper(root.left) : null;
    Pair rightPair = root.right != null ? helper(root.right) : null;
      
    root.left = null;
    TreeNode tail = root;
    
    if (leftPair != null && rightPair != null) {
      root.right = leftPair.head;
      leftPair.tail.right = rightPair.head;
      tail = rightPair.tail;
    } else if (leftPair != null) {
      root.right = leftPair.head;
      tail = leftPair.tail;
    } else {
      root.right = rightPair.head;
      tail = rightPair.tail;
    }
    
    return new Pair(root, tail);
  }
  
  private static class Pair {
    public TreeNode head;
    public TreeNode tail;
    
    public Pair(TreeNode head, TreeNode tail) {
      this.head = head;
      this.tail = tail;
    }
  }
}
