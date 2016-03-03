package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {    
    int listLen = getListLen(head, k);
    k = listLen == 0 ? 0 : k % listLen;
    
    if (k == 0) {
      return head;
    }
    
    k = listLen - k - 1;

    ListNode leftHead = head;
    ListNode leftEnd = head;
    while (k > 0) {
      --k;
      leftEnd = leftEnd.next;
    }
    
    ListNode rightHead = leftEnd.next;
    ListNode rightEnd = rightHead;
    
    while (rightEnd.next != null) {
      rightEnd = rightEnd.next;
    }
    
    leftEnd.next = null;
    rightEnd.next = leftHead;
    
    return rightHead;
  }
  
  private int getListLen(ListNode head, int k) {
    ListNode i = head;
    int listLen = 0;
    while (i != null) {
      ++listLen;
      i = i.next;
    }
    
    return listLen;
  }
}
