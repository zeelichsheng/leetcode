package leetcode.challenge;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.model.TreeLinkNode;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL. Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and
 * every parent has two children).
 * 
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachTreeNode {
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    
    Deque<TreeLinkNode> deque = new LinkedList<>();
    deque.addLast(root);
    
    while (!deque.isEmpty()) {
      int s = deque.size();
      TreeLinkNode prev = null;
      TreeLinkNode curr = null;
      while (s > 0) {
        curr = deque.removeFirst();
        
        if (prev != null) {
          prev.next = curr;
        }
        
        if (curr.left != null) {
          deque.addLast(curr.left);
        }
        
        if (curr.right != null) {
          deque.addLast(curr.right);
        }
        prev = curr;
        --s;
      }
    }
  }
}
