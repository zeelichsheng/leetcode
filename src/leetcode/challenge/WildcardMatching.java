package leetcode.challenge;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * 
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    s = s + '\0';
    p = p + '\0';
    int sIndex = 0;
    int pIndex = 0;
    int sStarIndex = -1;
    int pStarIndex = -1;
    
    while (s.charAt(sIndex) != '\0') {
      if (p.charAt(pIndex) == '?' ||
          s.charAt(sIndex) == p.charAt(pIndex)) {
        ++pIndex;
        ++sIndex;
        continue;
      }
      
      if (p.charAt(pIndex) == '*') {
        pStarIndex = pIndex;
        sStarIndex = sIndex;
        ++pIndex;
        continue;
      }
      
      if (pStarIndex != -1) {
        pIndex = pStarIndex + 1;
        ++sStarIndex;
        sIndex = sStarIndex;
        continue;
      }
      
      return false;
    }
    
    while (p.charAt(pIndex) == '*') {
      ++pIndex;
    }
    
    return p.charAt(pIndex) == '\0';
  }
  
  public static void main(String[] args) {
    WildcardMatching wm = new WildcardMatching();
    wm.isMatch("aa", "*");
  }
}
