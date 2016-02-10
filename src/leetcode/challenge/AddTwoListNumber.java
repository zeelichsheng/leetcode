package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoListNumber {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode p = null;
    int carry = 0;
    
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      if (sum > 9) {
        sum = sum - 10;
        carry = 1;
      } else {
        carry = 0;
      }
      
      ListNode newP = new ListNode(sum);
      
      if (p != null) {
        p.next = newP;
        p = newP;
      } else {
        head = newP;
        p = newP;
      }
            
      l1 = l1.next;
      l2 = l2.next;
    }
    
    while (l1 != null) {
      int sum = l1.val + carry;
      if (sum > 9) {
        sum = sum - 10;
        carry = 1;
      } else {
        carry = 0;
      }
      
      ListNode newP = new ListNode(sum);
      if (p != null) {
        p.next = newP;
        p = newP;
      } else {
        head = newP;
        p = newP;
      }
      
      l1 = l1.next;
    }
    
    while (l2 != null) {
      int sum = l2.val + carry;
      if (sum > 9) {
        sum = sum - 10;
        carry = 1;
      } else {
        carry = 0;
      }
      
      ListNode newP = new ListNode(sum);
      if (p != null) {
        p.next = newP;
        p = newP;
      } else {
        head = newP;
        p = newP;
      }
      
      l2 = l2.next;
    }
    
    if (carry != 0) {
      ListNode newP = new ListNode(carry);
      p.next = newP;
      p = newP;
    }
    
    return head;
  }
}
