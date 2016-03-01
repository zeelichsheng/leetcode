package leetcode.challenge;

/**
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; ++i) {
      if (!isValidSudoku(board, 0, 8, i, i)) {
        return false;
      }
      
      if (!isValidSudoku(board, i, i, 0, 8)) {
        return false;
      }
    }
    
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        if (!isValidSudoku(board, i * 3, i * 3 + 2, j * 3, j * 3 + 2)) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  private boolean isValidSudoku(char[][] board, int startX, int endX, int startY, int endY) {
    int flag = 0;
    for (int i = startX; i <= endX; ++i) {
      for (int j = startY; j <= endY; ++j) {
        if (board[i][j] == '.') {
          continue;
        }
        
        int val = board[i][j] - '0';
        if ((flag & (1 << val)) != 0) {
          return false;
        }
        
        flag |= (1 << val);
      }
    }
    
    return true;
  }
}
