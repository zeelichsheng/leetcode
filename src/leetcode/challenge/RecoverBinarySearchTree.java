package leetcode.challenge;

import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {
  public void recoverTree(TreeNode root) {
    if (root == null) {
      return;
    }
    
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    
    Stack<TreeNode> stack = new Stack<>();
    pushLeft(stack, root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      pushLeft(stack, root.right);
      
      if (prev != null && prev.val > root.val) {
        if (first == null) {
          first = prev;
        }
        
        second = root;
      }
      
      prev = root;
    }
    
    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
  }
  
  private void pushLeft(Stack<TreeNode> stack, TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }
}
