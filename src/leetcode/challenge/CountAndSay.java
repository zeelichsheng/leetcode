package leetcode.challenge;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
  public String countAndSay(int n) {
    String s = "1";
    
    for (int i = 1; i < n; ++i) {
      StringBuilder sb = new StringBuilder();
      int count = 1;
      for (int j = 1; j <= s.length(); ++j) {
        if (j == s.length() || s.charAt(j) != s.charAt(j - 1)) {
          sb.append(count);
          sb.append(s.charAt(j - 1));
          count = 1;
        } else {
          ++count;
        }
      }
      s = sb.toString();
    }
    
    return s;
  }
}
