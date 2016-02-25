package leetcode.challenge;

/**
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * 
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegexMatch {
  public boolean isMatch(String s, String p) {
    return isMatch(s + '\0', p + '\0', 0, 0);
  }
  
  private boolean isMatch(String s, String p, int sIndex, int pIndex) {
    if (p.charAt(pIndex) == '\0') {
      return s.charAt(sIndex) == '\0';
    }
    
    if (p.charAt(pIndex + 1) != '*') {
      return isCurrentIndexMatch(s, p, sIndex, pIndex) && isMatch(s, p, sIndex + 1, pIndex + 1);
    } else {
      while (isCurrentIndexMatch(s, p, sIndex, pIndex)) {
        if (isMatch(s, p, sIndex, pIndex + 2)) {
          return true;
        }
        
        sIndex++;
      }
      
      return isMatch(s, p, sIndex, pIndex + 2);
    }
  }
  
  private boolean isCurrentIndexMatch(String s, String p, int sIndex, int pIndex) {
    return (s.charAt(sIndex) == p.charAt(pIndex)) ||
        (s.charAt(sIndex) != '\0' && p.charAt(pIndex) == '.');
  }
}
