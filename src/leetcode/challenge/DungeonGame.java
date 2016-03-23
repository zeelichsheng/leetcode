package leetcode.challenge;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in
 * the top-left room and must fight his way through the dungeon to rescue the princess.
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to
 * 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in
 * each step.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * https://leetcode.com/problems/dungeon-game/
 */
public class DungeonGame {
  public int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;
    int[][] dp = new int[m][n];
    dp[m - 1][n - 1] = dungeon[m - 1][n - 1] < 0 ? 1 - dungeon[m - 1][n - 1] : 1;

    for (int i = m - 2; i >= 0; --i) {
      dp[i][n - 1] = dp[i + 1][n - 1] - dungeon[i][n - 1];
      if (dp[i][n - 1] <= 0) {
        dp[i][n - 1] = 1;
      }
    }

    for (int j = n - 2; j >= 0; --j) {
      dp[m - 1][j] = dp[m - 1][j + 1] - dungeon[m - 1][j];
      if (dp[m - 1][j] <= 0) {
        dp[m - 1][j] = 1;
      }
    }

    for (int i = m - 2; i >= 0; --i) {
      for (int j = n - 2; j >= 0; --j) {
        int down = dp[i + 1][j] - dungeon[i][j];
        if (down <= 0) {
          down = 1;
        }

        int right = dp[i][j + 1] - dungeon[i][j];
        if (right <= 0) {
          right = 1;
        }

        dp[i][j] = Math.min(down, right);
      }
    }

    return dp[0][0];
  }
}
