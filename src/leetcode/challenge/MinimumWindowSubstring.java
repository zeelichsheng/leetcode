package leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T
 * in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    Map<Character, Integer> needFind = new HashMap<>();
    Map<Character, Integer> hasFind = new HashMap<>();

    for (int i = 0; i < t.length(); ++i) {
      char c = t.charAt(i);

      if (needFind.containsKey(c)) {
        needFind.replace(c, needFind.get(c) + 1);
      } else {
        needFind.put(c, 1);
      }
    }

    int findCount = 0;
    int start = 0;
    String result = "";
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);

      if (!needFind.containsKey(c)) {
        continue;
      }

      if (hasFind.containsKey(c)) {
        hasFind.replace(c, hasFind.get(c) + 1);
      } else {
        hasFind.put(c, 1);
      }

      if (hasFind.get(c) <= needFind.get(c)) {
        ++findCount;
      }

      if (findCount == t.length()) {
        for (int j = start; j <= i; ++j) {
          char cj = s.charAt(j);

          if (!needFind.containsKey(cj)) {
            continue;
          }

          if (hasFind.get(cj) > needFind.get(cj)) {
            hasFind.replace(cj, hasFind.get(cj) - 1);
            continue;
          }

          start = j;
          break;
        }

        if (result.isEmpty() || result.length() > i - start + 1) {
          result = s.substring(start, i + 1);
        }
      }
    }

    return result;
  }
}
