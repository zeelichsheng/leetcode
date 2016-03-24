package leetcode.challenge;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has.
 *
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOfOneBits {
  public int hammingWeight(int n) {
    int result = 0;
    for (int i = 0; i < 32; ++i) {
      result += n & 1;
      n >>= 1;
    }

    return result;
  }
}
