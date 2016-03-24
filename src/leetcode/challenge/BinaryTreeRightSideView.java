package leetcode.challenge;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offer(root);
    while (!deque.isEmpty()) {
      result.add(deque.peekLast().val);
      int size = deque.size();
      while (size > 0) {
        TreeNode node = deque.poll();
        if (node.left != null) {
          deque.offer(node.left);
        }
        
        if (node.right != null) {
          deque.offer(node.right);
        }
        --size;
      }
    }
    
    return result;
  }
}
