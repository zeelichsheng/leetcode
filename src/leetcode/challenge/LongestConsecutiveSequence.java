package leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }

    int result = 0;
    for (int i : nums) {
      if (set.isEmpty()) {
        break;
      }

      if (!set.remove(i)) {
        continue;
      }

      int count = 1;
      int p = -1;
      while (set.contains(i + p)) {
        set.remove(i + p);
        --p;
        ++count;
      }

      p = 1;
      while (set.contains(i + p)) {
        set.remove(i + p);
        ++p;
        ++count;
      }

      result = Math.max(result, count);
    }

    return result;
  }
}
