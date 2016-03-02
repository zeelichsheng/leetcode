package leetcode.challenge;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    
    for (int y = 0; y < n; ++y) {
      for (int x = 0; x < (n / 2); ++x) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[n - x - 1][y];
        matrix[n - x - 1][y] = tmp;
      }
    }
    
    for (int x = 0; x < n; ++x) {
      for (int y = x; y < n; ++y) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[y][x];
        matrix[y][x] = tmp;
      }
    }
  }
}
