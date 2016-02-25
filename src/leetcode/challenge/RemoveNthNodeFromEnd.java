package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode i = head;
    ListNode iPrev = null;
    ListNode j = head;

    while (n > 0 && j != null) {
      j = j.next;
      --n;
    }

    while (j != null) {
      iPrev = i;
      i = i.next;
      j = j.next;
    }

    if (iPrev != null) {
      iPrev.next = i == null ? null : i.next;
      return head;
    } else {
      return head.next;
    }
  }
}
