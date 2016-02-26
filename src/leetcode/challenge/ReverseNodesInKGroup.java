package leetcode.challenge;

import leetcode.model.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode groupHeadPrev = null;
    ListNode groupHead = head;
    ListNode groupTail = getTail(groupHead, k);
    ListNode groupTailNext = groupTail != null ? groupTail.next : null;
    ListNode newHead = groupTail != null ? groupTail : head;

    while (groupHead != null && groupTail != null) {
      reverse(groupHeadPrev, groupHead, groupTail, groupTailNext);

      groupHeadPrev = groupHead;
      groupHead = groupTailNext;
      groupTail = getTail(groupHead, k);
      groupTailNext = groupTail != null ? groupTail.next : null;
    }

    return newHead;
  }

  private void reverse(ListNode groupHeadPrev, ListNode groupHead, ListNode groupTail, ListNode groupTailNext) {
    ListNode i = groupHead;
    ListNode j = i != null ? i.next : null;
    ListNode k = j != null ? j.next : null;
    while (j!= null && j != groupTailNext) {
      j.next = i;
      i = j;
      j = k;
      k = j != null ? j.next : null;
    }

    if (groupHeadPrev != null) {
      groupHeadPrev.next = groupTail;
    }

    if (groupHead != null) {
      groupHead.next = groupTailNext;
    }
  }

  private ListNode getTail(ListNode groupHead, int k) {
    while (k > 1 && groupHead != null) {
      groupHead = groupHead.next;
      --k;
    }

    return groupHead;
  }
}
