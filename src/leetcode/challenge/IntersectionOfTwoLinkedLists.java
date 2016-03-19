package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = getLength(headA);
    int lenB = getLength(headB);
    
    if (lenA > lenB) {
      headA = advance(headA, lenA - lenB);
    } else if (lenB > lenA) {
      headB = advance(headB, lenB - lenA);
    }
    
    while (headA != null && headB != null) {
      if (headA == headB) {
        return headA;
      }
      
      headA = headA.next;
      headB = headB.next;
    }
    
    return null;
  }
  
  private int getLength(ListNode head) {
    int len = 0;
    while (head != null) {
      ++len;
      head = head.next;
    }
    
    return len;
  }
  
  private ListNode advance(ListNode head, int steps) {
    while (head != null && steps > 0) {
      head = head.next;
      --steps;
    }
    
    return head;
  }
}
