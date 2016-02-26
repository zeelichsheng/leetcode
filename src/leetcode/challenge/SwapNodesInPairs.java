package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
  public ListNode swapPairs(ListNode head) {
    ListNode aPrev = null;
    ListNode a = head;
    ListNode b = a != null ? a.next : null;
    ListNode bNext = b != null ? b.next : null;
    ListNode newHead = head != null && head.next != null? head.next : head;

    while (a != null && b != null) {
      swap(aPrev, a, b, bNext);

      aPrev = a;
      a = bNext;
      b = a != null ? a.next : null;
      bNext = b != null ? b.next : null;
    }

    return newHead;
  }

  private void swap(ListNode aPrev, ListNode a, ListNode b, ListNode bNext) {
    if (b != null) {
      b.next = a;
    }

    if (aPrev != null) {
      aPrev.next = b;
    }

    if (a != null) {
      a.next = bNext;
    }
  }
}
