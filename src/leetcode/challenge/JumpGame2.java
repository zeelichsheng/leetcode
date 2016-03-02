package leetcode.challenge;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {
  public int jump(int[] nums) {
    int i = 0;
    int j = 0;
    int step = 0;
    
    while (j < nums.length) {
      int nextJ = 0;
      for (; i <= j; ++i) {
        nextJ = Math.max(nextJ, nums[i] + i);
        
        if (nextJ >= nums.length - 1) {
          return i != nums.length - 1 ? step + 1 : step;
        }
      }
      
      if (j >= nextJ) {
        return 0;
      }
      
      ++step;
      j = nextJ;
    }
    
    return step;
  }
}
