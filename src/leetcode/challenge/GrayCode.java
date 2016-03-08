package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence
 * of gray code. A gray code sequence must begin with 0.
 *
 * https://leetcode.com/problems/gray-code/
 */
public class GrayCode {
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0);

    for (int i = 0; i < n; ++i) {
      for (int j = result.size() - 1; j >= 0; --j) {
        result.add(result.get(j) + (1 << i));
      }
    }

    return result;
  }
}
