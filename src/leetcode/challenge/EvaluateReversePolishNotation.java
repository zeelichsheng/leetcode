package leetcode.challenge;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
  public int evaluate(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      if (token.matches("-?\\d+")) {
        stack.push(Integer.parseInt(token));
      } else {
        int b = stack.pop();
        int a = stack.pop();

        if (token.equals("+")) {
          stack.push(a + b);
        } else if (token.equals("-")) {
          stack.push(a - b);
        } else if (token.equals("*")) {
          stack.push(a * b);
        } else {
          stack.push(a / b);
        }
      }
    }

    return stack.pop();
  }
}
