package leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

  private static class BiListNode {
    public int key;
    public int value;
    public BiListNode next;
    public BiListNode prev;

    public BiListNode(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = null;
      this.prev = null;
    }
  }

  private int capacity;
  private int count;
  private BiListNode head;
  private BiListNode tail;
  private Map<Integer, BiListNode> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.count = 0;
    this.head = new BiListNode(-1, -1);
    this.tail = new BiListNode(-1, -1);
    head.next = tail;
    tail.prev = head;
    cache = new HashMap<>();
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    BiListNode node = cache.get(key);
    if (node.prev != head) {
      moveToQueueHead(node);
    }
    return node.value;
  }

  public void set(int key, int value) {
    if (cache.containsKey(key)) {
      BiListNode node = cache.get(key);
      node.value = value;
      if (node.prev != head) {
        moveToQueueHead(node);
      }

      return;
    }

    BiListNode node = new BiListNode(key, value);
    if (count == capacity) {
      cache.remove(tail.prev.key);
      dequeue(tail.prev);
      enqueue(node);
      cache.put(key, node);
    } else {
      enqueue(node);
      cache.put(key, node);
    }
  }

  private void enqueue(BiListNode node) {
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    node.prev = head;
    ++count;
  }

  private void dequeue(BiListNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    --count;
  }

  private void moveToQueueHead(BiListNode node) {
    dequeue(node);
    enqueue(node);
  }
}
