package leetcode.challenge;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
  public void solveSudoku(char[][] board) {
    boolean[][] rowMap = new boolean[9][9];
    boolean[][] colMap = new boolean[9][9];
    boolean[][] blockMap = new boolean[9][9];
    
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        int val = board[i][j] - '1';
        if (val >= 0) {
          rowMap[i][val] = true;
          colMap[j][val] = true;
          blockMap[i / 3 * 3 + j / 3][val] = true;
        }
      }
    }
    
    solveSudoku(board, 0, 0, rowMap, colMap, blockMap);
  }
  
  private boolean solveSudoku(char[][] board, int row, int col,
      boolean[][] rowMap, boolean [][] colMap, boolean[][] blockMap) {
    if (row == 9) {
      return true;
    }
    
    if (col == 9) {
      return solveSudoku(board, row + 1, 0, rowMap, colMap, blockMap);
    }
    
    if (board[row][col] != '.') {
      return solveSudoku(board, row, col + 1, rowMap, colMap, blockMap);
    }
    
    for (int i = 0; i < 9; ++i) {
      if (!rowMap[row][i] && !colMap[col][i] && !blockMap[row / 3 * 3 + col / 3][i]) {
        rowMap[row][i] = true;
        colMap[col][i] = true;
        blockMap[row / 3 * 3 + col / 3][i] = true;
        board[row][col] = (char)(i + '1');
        
        if (!solveSudoku(board, row, col + 1, rowMap, colMap, blockMap)) {
          rowMap[row][i] = false;
          colMap[col][i] = false;
          blockMap[row / 3 * 3 + col / 3][i] = false;
          board[row][col] = '.';
        } else {
          return true;
        }
      }
    }
    
    return false;
  }
}
