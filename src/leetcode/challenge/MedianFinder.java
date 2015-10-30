package leetcode.challenge;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 *
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {

  private PriorityQueue<Integer> lowerHalf;
  private PriorityQueue<Integer> upperHalf;

  public MedianFinder() {
    this.lowerHalf = new PriorityQueue<>(10, Collections.reverseOrder());
    this.upperHalf = new PriorityQueue<>();
  }

  /**
   * Adds an integer number from the data stream to the data structure.
   * @param num
   */
  public void addNum(int num) {
    if (this.lowerHalf.isEmpty()) {
      this.lowerHalf.offer(num);
    } else if (num < this.lowerHalf.peek()) {
      this.lowerHalf.offer(num);
    } else {
      this.upperHalf.offer(num);
    }

    int balance = this.lowerHalf.size() - this.upperHalf.size();

    if (balance > 1) {
      this.upperHalf.offer(this.lowerHalf.poll());
    }

    if (balance < -1) {
      this.lowerHalf.offer(this.upperHalf.poll());
    }
  }

  /**
   * Returns the median of all elements so far.
   * @return
   */
  public double findMedian() {
    int balance = this.lowerHalf.size() - this.upperHalf.size();

    if (balance == 0) {
      return (this.lowerHalf.peek() + this.upperHalf.peek()) / 2.0;
    } else if (balance > 0) {
      return this.lowerHalf.peek();
    } else {
      return this.upperHalf.peek();
    }
  }
}
