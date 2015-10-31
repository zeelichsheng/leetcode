package leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str. You may assume pattern
 * contains only lowercase letters, and str contains lowercase letters separated
 * by a single space.
 *
 * https://leetcode.com/problems/word-pattern/
 */
public class SimpleWordPattern {
  
  public boolean isMatch(String pattern, String str) {
    if (pattern == null) {
      return str == null;
    }
    
    if (str == null) {
      return pattern == null;
    }
    
    String[] arr = str.split(" ");
    if (arr.length != pattern.length()) {
      return false;
    }

    Map<Integer, String> patternToWord = new HashMap<>();
    Map<String, Integer> wordToPattern = new HashMap<>();
    for (int i = 0; i < arr.length; ++i) {
      Integer p = pattern.charAt(i) - 'a';
      String w = arr[i];

      String cw = patternToWord.putIfAbsent(p, w);
      if (cw != null && !w.equals(cw)) {
        return false;
      }

      Integer cp = wordToPattern.putIfAbsent(w, p);
      if (cp != null && !p.equals(cp)) {
        return false;
      }
    }

    return true;
  }
}
