package leetcode.challenge;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT
 * 
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
  public static int divide(int dividend, int divisor) {
    if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
      return Integer.MAX_VALUE;
    }
    
    if (dividend == 0) {
      return 0;
    }
    
    boolean isNegative = (dividend < 0) != (divisor < 0);
    long ldividend = Math.abs((long)dividend);
    long ldivisor = Math.abs((long)divisor);
    
    long bit = 1;
    while (ldividend > ldivisor) {
      ldivisor <<= 1;
      bit <<= 1;
    }
    
    int r = 0;
    while (bit > 0) {
      if (ldivisor <= ldividend) {
        ldividend -= ldivisor;
        r += bit;
      }
      
      bit >>= 1;
      ldivisor >>= 1;
    }
    
    return isNegative ? -r : r;
  }
}
