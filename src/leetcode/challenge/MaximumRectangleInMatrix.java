package leetcode.challenge;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximumRectangleInMatrix {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length <= 0 || matrix[0].length <= 0) {
      return 0;
    }
    
    int m = matrix.length;
    int n = matrix[0].length + 1;
    int[] height = new int[n];
    int result = 0;    
    
    for (int i = 0; i < m; ++i) {
      Stack<Integer> st = new Stack<Integer>();
      for (int j = 0; j < n; ++j) {
        if (j < n - 1) {
          if (matrix[i][j] == '1') {
            height[j] += 1;            
          } else {
            height[j] = 0;
          }
        }
        
        while (!st.isEmpty() && height[st.peek()] >= height[j]) {
          int h = height[st.pop()];
          int w = st.isEmpty() ? j : j - st.peek() - 1;
          result = Math.max(result, h * w);
        }
        
        st.push(j);
      }
    }
    
    return result;
  }
}
