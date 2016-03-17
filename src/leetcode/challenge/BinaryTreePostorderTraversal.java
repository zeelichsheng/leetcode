package leetcode.challenge;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);

    return result;
  }

  private void helper(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }

    helper(root.left, result);
    helper(root.right, result);
    result.add(root.val);
  }
}
