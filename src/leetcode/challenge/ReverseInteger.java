package leetcode.challenge;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
  public int reverse(int x) {
    boolean isNegative = x < 0;
    x = Math.abs(x);
    
    int revX = 0;
    while (x > 0) {
      if (Integer.MAX_VALUE / 10 < revX ||
          Integer.MAX_VALUE - revX * 10 < x % 10) {
        return 0;
      }
        
      revX = revX * 10 + x % 10;
      x = x / 10;
    }
    
    if (isNegative) {
      revX = - revX;
    }
    
    return revX;
  }
}
