package leetcode.challenge;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {
  Stack<Integer> stack = new Stack<>();
  Stack<Integer> minStack = new Stack<>();
  
  public void push(int x) {
    stack.push(x);
    
    if (minStack.isEmpty()) {
      minStack.push(x);
    } else {
      int lastMin = minStack.peek();
      minStack.push(lastMin < x ? lastMin : x);
    }
  }
  
  public void pop() {
    stack.pop();
    minStack.pop();
  }
  
  public int top() {
    return stack.peek();
  }
  
  public int getMin() {
    return minStack.peek();
  }
}
