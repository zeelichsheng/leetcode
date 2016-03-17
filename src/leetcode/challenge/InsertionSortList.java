package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Sort a linked list using insertion sort.
 *
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    ListNode newHead = new ListNode(0);

    while (head != null) {
      ListNode n = newHead.next;
      ListNode nPrev = newHead;
      ListNode headNext = head.next;

      while (n != null && n.val < head.val) {
        nPrev = n;
        n = n.next;
      }

      nPrev.next = head;
      head.next = n;

      head = headNext;
    }

    return newHead.next;
  }
}
