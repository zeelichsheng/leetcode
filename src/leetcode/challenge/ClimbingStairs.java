package leetcode.challenge;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
  public int climbStairs(int n) {
    if (n < 3) {
      return n;
    }

    int twoStepBefore = 1;
    int oneStepBefore = 2;
    int step = 0;

    for (int i = 2; i < n; ++i) {
      step = twoStepBefore + oneStepBefore;
      twoStepBefore = oneStepBefore;
      oneStepBefore = step;
    }

    return step;
  }
}
