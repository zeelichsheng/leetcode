package leetcode.challenge;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);

    return result;
  }

  private void helper(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }

    result.add(root.val);
    helper(root.left, result);
    helper(root.right, result);
  }
}
