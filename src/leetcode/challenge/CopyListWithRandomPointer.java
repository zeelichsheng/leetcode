package leetcode.challenge;

import leetcode.model.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null. Return a deep copy of the list.
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
  public RandomListNode copy(RandomListNode head) {
    if (head == null) {
      return null;
    }

    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode oldNode = head;
    RandomListNode newHead = null;
    RandomListNode newNode = null;
    RandomListNode newNodePrev = null;

    while (oldNode != null) {
       newNode = new RandomListNode(oldNode.label);

      if (newHead == null) {
        newHead = newNode;
      }

      if (newNodePrev != null) {
        newNodePrev.next = newNode;
      }

      map.put(oldNode, newNode);
      oldNode = oldNode.next;
      newNodePrev = newNode;
    }

    oldNode = head;

    while (oldNode != null) {
      newNode = map.get(oldNode);

      if (oldNode.random != null) {
        newNode.random = map.get(oldNode.random);
      }

      oldNode = oldNode.next;
    }

    return newHead;
  }
}
