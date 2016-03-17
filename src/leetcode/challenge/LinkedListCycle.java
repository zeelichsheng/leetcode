package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
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

    return slow != null && fast != null;
  }
}
