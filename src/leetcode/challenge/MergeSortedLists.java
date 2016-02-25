package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode i = head;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        i.next = l1;
        i = l1;
        l1 = l1.next;
      } else {
        i.next = l2;
        i = l2;
        l2 = l2.next;
      }
    }

    while (l1 != null) {
      i.next = l1;
      i = l1;
      l1 = l1.next;
    }

    while (l2 != null) {
      i.next = l2;
      i = l2;
      l2 = l2.next;
    }

    return head.next;
  }
}
