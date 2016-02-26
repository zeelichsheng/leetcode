package leetcode.challenge;

import leetcode.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    if (lists.length == 1) {
      return lists[0];
    }

    ListNode head = new ListNode(0);
    ListNode node = head;
    PriorityQueue<ListNode> heap = new PriorityQueue<>(
        lists.length,
        new ListNodeComparator());

    for (int i = 0; i < lists.length; ++i) {
      if (lists[i] != null) {
        heap.offer(lists[i]);
      }
    }

    while (!heap.isEmpty()) {
      ListNode minNode = heap.peek();
      heap.remove(minNode);
      if (minNode.next != null) {
        heap.offer(minNode.next);
      }

      node.next = minNode;
      node = minNode;
    }

    return head.next;
  }

  public static class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode n1, ListNode n2) {
      return n1.val - n2.val;
    }
  }
}
