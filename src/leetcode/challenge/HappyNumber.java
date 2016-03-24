package leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the
 * sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1. Those numbers for which this
 * process ends in 1 are happy numbers.
 * 
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> used = new HashSet<>();
    while (n != 1 && !used.contains(n)) {
      used.add(n);
      n = transform(n);
    }
    
    return n == 1;
  }
  
  private int transform(int n) {
    int result = 0;
    while (n != 0) {
      int a = n % 10;
      result += a * a;
      n = n / 10;
    }
    
    return result;
  }
}
