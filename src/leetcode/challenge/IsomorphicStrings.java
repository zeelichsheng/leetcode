package leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    
    Map<Character, Character> stMap = new HashMap<>();
    Map<Character, Character> tsMap = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      
      if (stMap.containsKey(sc) && stMap.get(sc) != tc) {
        return false;
      }
      
      if (tsMap.containsKey(tc) && tsMap.get(tc) != sc) {
        return false;
      }
      
      stMap.put(sc, tc);
      tsMap.put(tc, sc);
    }
    
    return true;
  }
}
