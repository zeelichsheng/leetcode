package leetcode.challenge;

import java.util.Map;
import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeat {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    
    int maxLen = 0;
    int j = 0;    
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      
      if (!map.containsKey(c)) {
        map.put(c, i);
      } else {
        int r = map.get(c);
        
        if (r >= j) {
          j = r + 1;
        }
        
        map.replace(c, i);
      }
      
      if (i - j + 1 > maxLen) {
        maxLen = i - j + 1;
      }
    }
    
    return maxLen;
  }
}
