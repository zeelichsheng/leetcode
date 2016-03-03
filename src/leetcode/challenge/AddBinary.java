package leetcode.challenge;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
  public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    String result = "";

    while (i >= 0 && j >= 0) {
      int aVal = a.charAt(i) - '0';
      int bVal = b.charAt(j) - '0';
      int sum = aVal + bVal + carry;
      carry = sum / 2;
      sum = sum % 2;

      result += (char)(sum + '0');
      --i;
      --j;
    }

    while (i >= 0) {
      int aVal = a.charAt(i) - '0';
      int sum = aVal + carry;
      carry = sum / 2;
      sum = sum % 2;

      result += (char)(sum + '0');
      --i;
    }

    while (j >= 0) {
      int bVal = b.charAt(j) - '0';
      int sum = bVal + carry;
      carry = sum / 2;
      sum = sum % 2;

      result += (char)(sum + '0');
      --j;
    }

    if (carry > 0) {
      result += (char)(carry + '0');
    }

    return new StringBuilder(result).reverse().toString();
  }
}
