package leetcode.challenge;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int mostWater = 0;
    while (left < right) {
      mostWater = Math.max(mostWater, Math.min(height[left], height[right]) * (right - left));
      
      if (height[left] > height[right]) {
        --right;
      } else {
        ++left;
      }
    }
    
    return mostWater;
  }
}
