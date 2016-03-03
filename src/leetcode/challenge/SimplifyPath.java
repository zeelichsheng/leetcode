package leetcode.challenge;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
  public String simplifyPath(String path) {
    String[] directories = path.split("/");
    Stack<String> st = new Stack<>();
    for (int i = 0; i < directories.length; ++i) {
      if (directories[i].isEmpty() || directories[i].equals(".")) {
        continue;
      } else if (directories[i].equals("..")) {
        if (!st.isEmpty()) {
          st.pop();
        }
      } else {
        st.push(directories[i]);
      }
    }

    String result = "";
    while (!st.isEmpty()) {
      result = "/" + st.pop() + result;
    }

    if (result.isEmpty()) {
      result = "/";
    }

    return result;
  }
}
