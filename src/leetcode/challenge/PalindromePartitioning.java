package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return result;
    }
    
    boolean[][] isPalin = new boolean[s.length()][s.length()];
    
    for (int i = 0, count = s.length(); i < s.length(); ++i, --count) {
      for (int j = 0; j < count; ++j) {
        isPalin[j][j + i] = s.charAt(j) == s.charAt(j + i) && (j + 1 >= j + i - 1 ? true : isPalin[j + 1][j + i - 1]);
      }
    }
    
    helper(s, 0, isPalin, new ArrayList<>(), result);
    
    return result;
  }
  
  private void helper(String s, int index, boolean[][] isPalin, List<String> cache, List<List<String>> result) {
    if (index == s.length()) {
      result.add(new ArrayList<>(cache));
      return;
    }
    
    for (int i = index; i < s.length(); ++i) {
      if (isPalin[index][i]) {
        cache.add(s.substring(index, i + 1));
        helper(s, i + 1, isPalin, cache, result);
        cache.remove(cache.size() - 1);
      }
    }
  }
}
