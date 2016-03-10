package leetcode.challenge;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    
    while (!queue.isEmpty()) {
      List<Integer> values = new ArrayList<>();
      int currQueueSize = queue.size();
      for (int i = 0; i < currQueueSize; ++i) {
        TreeNode node = queue.removeFirst();
        
        if (node != null) {
          queue.addLast(node.left);
          queue.addLast(node.right);
          values.add(node.val);
        } else {
          values.add(null);
        }
      }
      
      for (int i = 0; i < values.size(); ++i) {
        Integer a = values.get(i);
        Integer b = values.get(values.size() - i - 1);
        
        if (a == null && b == null) {
          continue;
        }
        
        if (a != null && b != null && a.equals(b)) {
          continue;
        }
        
        return false;
      }
    }
    
    return true;
  }
}
