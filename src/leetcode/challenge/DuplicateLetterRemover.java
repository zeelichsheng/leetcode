package leetcode.challenge;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters
 * so that every letter appear once and only once. You must make sure your result
 * is the smallest in lexicographical order among all possible results.
 *
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class DuplicateLetterRemover {

  /**
   * Removes the duplicated letters from the given string.
   * @param s
   * @return
   */
  public String removeDuplicateLetters(String s) {
    int[] count = new int[26];
    boolean[] inResult = new boolean[26];
    char[] result = new char[s.length()];

    s.chars().forEach(c -> ++count[c - 97]);

    int t = -1;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (inResult[c - 97]) {
        --count[c - 97];
        continue;
      }

      while (t >= 0 && c < result[t] && count[result[t] - 97] > 0) {
        inResult[result[t] - 97] = false;
        --t;
      }

      result[++t] = c;
      inResult[c - 97] = true;
      --count[c - 97];
    }

    return String.valueOf(result).substring(0, t + 1);
  }
}
