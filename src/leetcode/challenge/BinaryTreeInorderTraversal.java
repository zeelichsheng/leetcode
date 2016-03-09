package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }
  
  private void traverse(TreeNode node, List<Integer> result) {
    if (node == null) {
      return;
    }
    
    traverse(node.left, result);
    result.add(node.val);
    traverse(node.right, result);
  }
}
