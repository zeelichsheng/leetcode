package leetcode.challenge;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
  public boolean canJump(int[] nums) {
    int start = 0;
    while (true) {
      int maxReach = 0;
      int nextStart = start;
      for (int i = start; i <= nums[start] + start; ++i) {
        int jump = i + nums[i];
        
        if (jump >= nums.length - 1) {
          return true;
        }
        
        if (jump > maxReach) {
          maxReach = jump;
          nextStart = i;
        }        
      }
      
      if (start == nextStart) {
        return false;
      }
      
      start = nextStart;
    }
  }
}
