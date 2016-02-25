package leetcode.challenge;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')',
 * '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}"
 * are all valid but "(]" and "([)]" are not.
 *
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);

      if (c == '(' || c == '[' || c == '{') {
        st.push(c);
      } else {
        if (st.isEmpty()) {
          return false;
        }

        char tc = st.pop();

        if ((c == ')' && tc != '(') ||
            (c == ']' && tc != '[') ||
            (c == '}' && tc != '{')) {
          return false;
        }
      }
    }

    return st.isEmpty();
  }
}
