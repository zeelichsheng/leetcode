package leetcode.challenge;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 *
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
  public int numDecodings(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;

    int i = 0;
    while (i < s.length() && s.charAt(i) == '0') {
      ++i;
    }

    if (i != 0) {
      return 0;
    }

    for (i = 2; i < s.length() + 1; ++i) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }

      if (s.charAt(i - 2) == '1' ||
          (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[s.length()];
  }
}
