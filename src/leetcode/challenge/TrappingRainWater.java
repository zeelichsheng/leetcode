package leetcode.challenge;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
  public int trap(int[] height) {
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    int currLeftMax = 0;
    int currRightMax = 0;
    int water = 0;

    for (int i = 0; i < height.length; ++i) {
      int j = height.length - i - 1;
      currLeftMax = Math.max(currLeftMax, height[i]);
      currRightMax = Math.max(currRightMax, height[j]);
      leftMax[i] = currLeftMax;
      rightMax[j] = currRightMax;
    }

    for (int i = 0; i < height.length; ++i) {
      water += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return water;
  }
}
