package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens
 * attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 *
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
  public List<List<String>> solveNQueens(int n) {
    int[] taken = new int[n];
    for (int i = 0; i < n; ++i) {
      taken[i] = -1;
    }
    List<List<String>> result = new ArrayList<>();

    helper(n, 0, taken, result);
    return result;
  }

  private void helper(int n, int row, int[] taken, List<List<String>> result) {
    if (row == n) {
      List<String> board = new ArrayList<>();
      for (int i = 0; i < n; ++i) {
        String rowOnBoard = "";
        for (int j = 0; j < n; ++j) {
          if (taken[i] == j) {
            rowOnBoard += 'Q';
          } else {
            rowOnBoard += '.';
          }
        }

        board.add(rowOnBoard);
      }

      result.add(board);
      return;
    }

    for (int j = 0; j < n; ++j) {
      boolean use = true;
      for (int i = 0; i < row; ++i) {
        if (taken[i] == j ||
            Math.abs(i - row) == Math.abs(taken[i] - j)) {
          use = false;
          break;
        }
      }

      if (use) {
        taken[row] = j;
        helper(n, row + 1, taken, result);
        taken[row] = -1;
      }
    }
  }
}
