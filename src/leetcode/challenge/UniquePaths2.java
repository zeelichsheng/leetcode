package leetcode.challenge;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePaths2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;    
    int[][] dp = new int[m][n];
    dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
    
    for (int i = 1; i < m; ++i) {
      dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
    }
    
    for (int j = 1; j < n; ++j) {
      dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
    }
    
    for (int i = 1; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
      }
    }
    
    return dp[m - 1][n - 1];
  }
}
