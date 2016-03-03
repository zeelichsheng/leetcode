package leetcode.challenge;

/**
 * Compute and return the square root of x.
 *
 * https://leetcode.com/problems/sqrtx/
 */
public class SquareRoot {
  public int mySqry(int x) {
    long lx = (long)x;
    if (lx <= 1) {
      return x;
    }

    int l = 0;
    int r = x;

    while (l < r) {
      int m = (l + r) / 2 + 1;
      long mul = (long)m * (long)m;
      if (mul == lx) {
        return m;
      } else if (mul < lx) {
        l = m;
      } else {
        r = m - 1;
      }
    }

    return l;
  }
}
