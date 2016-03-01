package leetcode.challenge;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest
 * valid (well-formed) parentheses substring.
 *
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
  public int longestValidParenteses(String s) {
    Stack<Integer> index = new Stack<>();
    int longest = 0;

    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);

      if (c == '(') {
        index.push(i);
      } else {
        if (index.isEmpty() || s.charAt(index.peek()) == ')') {
          index.push(i);
        } else {
          index.pop();
          if (!index.isEmpty()) {
            longest = Math.max(longest, i - index.peek());
          } else {
            longest = i + 1;
          }
        }
      }
    }

    return longest;
  }
}
