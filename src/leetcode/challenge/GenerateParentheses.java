package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
  public List<String> generateParentheses(int n) {
    String p = "";
    List<String> result = new ArrayList<>();
    generateParentheses(p, result, n, 0);
    return result;
  }

  private void generateParentheses(String p, List<String> result, int open, int close) {
    if (open == 0 && close == 0) {
      result.add(p);
      return;
    }

    if (open > 0) {
      generateParentheses(p + '(', result, open - 1, close + 1);
    }

    if (close > 0) {
      generateParentheses(p + ')', result, open, close - 1);
    }
  }
}
