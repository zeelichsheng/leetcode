package leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains
 * any duplicates. Your function should return true if any
 * value appears at least twice in the array, and it should
 * return false if every element is distinct.
 *
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    Set<Integer> hash = new HashSet<>();
    for (int i : nums) {
      if (!hash.add(i)) {
        return true;
      }
    }

    return false;
  }
}
