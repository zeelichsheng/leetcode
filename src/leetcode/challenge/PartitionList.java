package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x
 * come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    
    ListNode tail = getTail(head);
    if (tail == head) {
      return head;
    }
    
    ListNode newHead = head;
    ListNode newTail = tail;
    ListNode iPrev = null;
    ListNode i = head;
    ListNode iNext = i.next;
    while (i != tail) {
      if (i.val >= x) { 
        newTail.next = i;
        newTail = i;
        newTail.next = null;
        
        if (iPrev != null) {
          iPrev.next = iNext;
        }
        
        if (i == newHead) {
          newHead = iNext;
        }
        
        i = iNext;
        iNext = i.next;
      } else {
        iPrev = i;
        i = iNext;
        iNext = i.next;
      }
    }
    
    if (tail != newTail && i.val >= x) {
      newTail.next = i;
      newTail = i;
      i.next = null;
      
      if (iPrev != null) {
        iPrev.next = iNext;
      }
      
      if (i == newHead) {
        newHead = iNext;
      }      
    }
    
    return newHead;
  }
  
  private ListNode getTail(ListNode head) {
    while (head != null && head.next != null) {
      head = head.next;
    }
    
    return head;
  }
}
