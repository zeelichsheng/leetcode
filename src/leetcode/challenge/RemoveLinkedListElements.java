package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    ListNode newHead = null;
    ListNode node = head;
    ListNode prevNode = null;
    
    while (node != null) {
      if (node.val != val) {
        if (newHead == null) {
          newHead = node;
        }
        
        prevNode = node;
        node = node.next;
      } else {
        node = node.next;
        if (prevNode != null) {
          prevNode.next = node;
        }
      }
    }
    
    return newHead;
  }
}
