package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Reverse a singly linked list.
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    ListNode prevNode = null;
    ListNode node = head;
    ListNode nextNode = node == null ? null : node.next;
    
    while (node != null) {
      node.next = prevNode;
      prevNode = node;
      node = nextNode;
      nextNode = node == null ? null : node.next;
    }
    
    return prevNode;
  }
}
