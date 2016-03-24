package leetcode.challenge;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * 
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
public class BitwiseAndOfNumbersRange {
  public int rangeBitwiseAnd(int m, int n) {
    int bit = 1;
    int result = 0;
    int diff = n - m;
    for (int i = 0; i < 32; ++i) {
      if (((m & bit) != 0) &&
          (diff < bit - m % bit)) {
        result |= bit;
      }
      
      bit <<= 1;
    }
    
    return result;
  }
}
