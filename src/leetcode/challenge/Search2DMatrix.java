package leetcode.challenge;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
      return false;
    }

    for (int i = 0; i < m; ++i) {
      if (target > matrix[i][n - 1]) {
        continue;
      }

      for (int j = 0; j < n; ++j) {
        if (target == matrix[i][j]) {
          return true;
        }
      }
    }

    return false;
  }
}
