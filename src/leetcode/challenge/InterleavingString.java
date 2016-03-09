package leetcode.challenge;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    
    s1 = s1 + '\0';
    s2 = s2 + '\0';
    s3 = s3 + '\0';
    int[][][] cache = new int[s1.length()][s2.length()][s3.length()];
    for (int i = 0; i < s1.length(); ++i) {
      for (int j = 0; j < s2.length(); ++j) {
        for (int k = 0; k < s3.length(); ++k) {
          cache[i][j][k] = -1;
        }
      }
    }
    
    return isInterleave(s1, 0, s2, 0, s3, 0, cache);
  }
  
  private boolean isInterleave(String s1, int s1Index, String s2, int s2Index, String s3, int s3Index,
      int[][][] cache) {
    if (s1Index == s1.length() - 1 && s2Index == s2.length() - 1 && s3Index == s3.length() - 1) {
      return true;
    }
    
    if (cache[s1Index][s2Index][s3Index] != -1) {
      return cache[s1Index][s2Index][s3Index] == 1;
    }
    
    char c1 = s1.charAt(s1Index);
    char c2 = s2.charAt(s2Index);
    char c3 = s3.charAt(s3Index);
    
    boolean b = false;
    if (c1 == c3 && c2 == c3) {
      b = isInterleave(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1, cache) ||
          isInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1, cache);
    }
    
    if (c1 == c3 && c2 != c3) {
      b = isInterleave(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1, cache);
    }
    
    if (c1 != c3 && c2 == c3) {
      b = isInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1, cache);
    }
    
    if (b) {
      cache[s1Index][s2Index][s3Index] = 1;
    } else {
      cache[s1Index][s2Index][s3Index] = 0;
    }
    
    return b;
  }
}
