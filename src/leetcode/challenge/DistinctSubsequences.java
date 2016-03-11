package leetcode.challenge;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters.
 * 
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {
  public int numDistinct(String s, String t) {
    int[] dp = new int[t.length()];
    for (int i = 0; i < s.length(); ++i) {
      for (int j = t.length() - 1; j >=0; --j) {
        if (s.charAt(i) == t.charAt(j)) {
          dp[j] = (j == 0 ? 1 : dp[j - 1]) + dp[j];
        }
      }
    }
    
    return dp[t.length() - 1];
  }
}
