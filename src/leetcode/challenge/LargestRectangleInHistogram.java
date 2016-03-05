package leetcode.challenge;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    int result = 0;
    for (int i = 0; i < heights.length; ++i) {
      if (i < heights.length - 1 && heights[i] <= heights[i + 1]) {
        continue;
      }
      
      int minHeight = Integer.MAX_VALUE;
      for (int j = i; j >= 0; --j) {
        minHeight = Math.min(minHeight, heights[j]);
        result = Math.max(result, minHeight * (i - j + 1));
      }
    }
    
    return result;
  }
}
