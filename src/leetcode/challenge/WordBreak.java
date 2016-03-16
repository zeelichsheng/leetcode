package leetcode.challenge;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 *
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {
  public boolean wordBreak(String s, Set<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 0; i < s.length(); ++i) {
      if (!dp[i]) {
        continue;
      }

      for (String word : wordDict) {
        int index = i + word.length();

        if (index > s.length()) {
          continue;
        }

        if (dp[index]) {
          continue;
        }

        dp[index] = s.substring(i, i + word.length()).equals(word);
      }
    }

    return dp[s.length()];
  }
}
