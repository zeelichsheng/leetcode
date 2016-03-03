package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    List<Integer> result = new ArrayList<>();
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; --i) {
      int sum = digits[i] + carry;
      if (sum > 9) {
        sum = sum - 10;
        carry = 1;
      } else {
        carry = 0;
      }

      result.add(sum);
    }

    if (carry > 0) {
      result.add(carry);
    }

    int[] ret = new int[result.size()];
    for (int i = result.size() - 1; i >= 0; --i) {
      ret[result.size() - i - 1] = result.get(i);
    }

    return ret;
  }
}
