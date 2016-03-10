package leetcode.challenge;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrderTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> deque = new LinkedList<>();
    deque.addLast(root);
    
    while (!deque.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int currLevelSize = deque.size();
      
      for (int i = 0; i < currLevelSize; ++i) {
        TreeNode node = deque.removeFirst();
        
        if (node != null) {
          level.add(node.val);
          deque.addLast(node.left);
          deque.addLast(node.right);
        }
      }
      
      if (!level.isEmpty()) {
        result.add(level);
      }
    }
    
    return result;
  }
}
