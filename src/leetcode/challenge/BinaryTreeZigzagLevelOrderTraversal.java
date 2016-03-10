package leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root) {
    boolean leftToRight = true;
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
        if (!leftToRight) {
          Collections.reverse(level);
        }
        result.add(level);
      }
      
      leftToRight = !leftToRight;
    }
    
    return result;
  }
}
