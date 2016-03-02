package leetcode.challenge;

/**
 * Implement pow(x, n).
 * 
 * https://leetcode.com/problems/powx-n/
 */
public class PowerOfN {
  public double myPow(double x, int n) {
    if (n == Integer.MIN_VALUE) {
      if (x != 1.0 && x != -1.0) {
        return 0.0;
      } else {
        return 1.0;
      }
    }
    
    boolean isNegative = n < 0;
    double result = myPowHelper(x, Math.abs(n));
    return isNegative ? 1.0 / result : result;
  }
  
  private double myPowHelper(double x, int n) {
    if (n == 0) {
      return 1.0;
    }
    
    double mul = myPowHelper(x, n / 2);
    mul *= mul;
    if (n % 2 == 1) {
      mul *= x;
    }
    
    return mul;
  }
}
