package leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class FractionToRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }

    int sign = (numerator ^ denominator) >> 31;
    StringBuilder ans = new StringBuilder();
    if (sign != 0) {
      ans.append("-");
    }

    Long ln = Math.abs(Long.valueOf(numerator));
    Long ld = Math.abs(Long.valueOf(denominator));
    ans.append(ln / ld);
    Long rem = ln % ld;
    if (rem == 0) {
      return ans.toString();
    }

    ans.append(".");
    rem *= 10;
    Map<Long, Integer> index = new HashMap<>();
    StringBuilder decimal = new StringBuilder();
    for (int i = 0; rem != 0; ++i) {
      if (!index.containsKey(rem)) {
        index.put(rem, i);
        decimal.append(rem / ld);
        rem  = (rem % ld) * 10;
      } else {
        decimal.insert((int)index.get(rem), '(');
        decimal.append(')');
        break;
      }
    }

    ans.append(decimal.toString());
    return ans.toString();
  }
}
