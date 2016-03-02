package leetcode.challenge;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as
 * a string. Note: The numbers can be arbitrarily large and are non-negative.
 *
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int len = len1 + len2;
    int[] arr = new int[len];

    for (int i = len1 - 1; i >= 0; --i) {
      for (int j = len2 - 1; j >= 0; --j) {
        arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
      }
    }

    for (int i = len - 1; i > 0; --i) {
      arr[i - 1] += arr[i] / 10;
      arr[i] %= 10;
    }

    int i = 0;
    while (i < len && arr[i] == 0) {
      ++i;
    }

    if (i == len) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    while (i < len) {
      sb.append((char)(arr[i] + '0'));
      ++i;
    }

    return sb.toString();
  }
}
