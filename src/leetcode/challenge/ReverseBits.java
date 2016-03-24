package leetcode.challenge;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {
  public int reverseBits(int n) {
    int m = 0;
    for (int i = 0; i < 32; ++i) {
      m = m << 1 | n & 1;
      n >>= 1;
    }

    return m;
  }
}
