package leetcode.challenge;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
  public boolean isValid(String s) {
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      while (i < s.length() && !isDigit(s.charAt(i)) && !isAlpha(s.charAt(i))) {
        ++i;
      }

      while (j >= 0 && !isDigit(s.charAt(j)) && !isAlpha(s.charAt(j))) {
        --j;
      }

      if (i < s.length() && j >= 0 && !isEqual(s.charAt(i), s.charAt(j))) {
        return false;
      }

      ++i;
      --j;
    }

    return true;
  }

  private boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }

  private boolean isAlpha(char c) {
    return (c >= 'A' && c <= 'Z') ||
        (c >= 'a' && c <= 'z');
  }

  private boolean isEqual(char a, char b) {
    int diff = Math.abs(a - b);
    if (isDigit(a) && isDigit(b)) {
      return diff == 0;
    }

    if (isAlpha(a) && isAlpha(b)) {
      return diff == 0 || diff == 32;
    }

    return false;
  }
}
