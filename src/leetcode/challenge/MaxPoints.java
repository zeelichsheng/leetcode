package leetcode.challenge;

import leetcode.model.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPoints {
  public int maxPoints(Point[] points) {
    if (points.length < 2) {
      return points.length;
    }

    int max = 2;
    for (Point p : points) {
      Map<Integer, Integer> slopes = new HashMap<>(points.length);
      int localMax = 0;
      for (Point q : points) {
        int a = q.y - p.y;
        int b = q.x - p.x;

        int sign = (a > 0 && b < 0) || (a < 0 && b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);

        int gcd = gcd(a, b);
        a = gcd == 0 ? a : a / gcd;
        b = gcd == 0 ? b : b / gcd;

        int m = sign * (a + b) * (a + b + 1) / 2 + b;
        if (slopes.containsKey(m)) {
          slopes.put(m, slopes.get(m) + 1);
        } else {
          slopes.put(m, 1);
        }

        if (m == 0) {
          continue;
        }

        localMax = Math.max(slopes.get(m), localMax);
      }

      max = Math.max(max, localMax + slopes.get(0));
    }

    return max;
  }

  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }

    return gcd(b, a % b);
  }
}
