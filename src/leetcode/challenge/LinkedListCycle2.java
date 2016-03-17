package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycle2 {
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;
    do {
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    } while (slow != null && fast != null && slow != fast);

    if (slow == null || fast == null) {
      return null;
    }

    slow = head;

    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}
