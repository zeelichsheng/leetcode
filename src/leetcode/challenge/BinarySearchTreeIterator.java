package leetcode.challenge;

import leetcode.model.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and
 * uses O(h) memory, where h is the height of the tree.
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BinarySearchTreeIterator {
  private Stack<TreeNode> minNodes;

  public BinarySearchTreeIterator(TreeNode root) {
    minNodes = new Stack<>();
    fillMinNodes(root);
  }

  public boolean hasNext() {
    return !minNodes.isEmpty();
  }

  public int next() {
    TreeNode minNode = minNodes.pop();
    fillMinNodes(minNode.right);
    return minNode.val;
  }

  private void fillMinNodes(TreeNode root) {
    while (root != null) {
      minNodes.push(root);
      root = root.left;
    }
  }
}
