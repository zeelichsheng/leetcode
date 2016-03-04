package leetcode.challenge;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
  public boolean exist(char[][] board, String word) {
    boolean[][] used = new boolean[board.length][board[0].length];

    for (int x = 0; x < board.length; ++x) {
      for (int y = 0; y < board[0].length; ++y) {
        if (exist(board, x, y, used, word, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean exist(char[][] board, int x, int y, boolean[][] used, String word, int wordIndex) {
    if (board[x][y] != word.charAt(wordIndex)) {
      return false;
    }

    if (wordIndex == word.length() - 1) {
      return true;
    }

    used[x][y] = true;
    if (x > 0 && !used[x - 1][y]) {
      if (exist(board, x - 1, y, used, word, wordIndex + 1)) {
        return true;
      }
    }

    if (x < board.length - 1 && !used[x + 1][y]) {
      if (exist(board, x + 1, y, used, word, wordIndex + 1)) {
        return true;
      }
    }

    if (y > 0 && !used[x][y - 1]) {
      if (exist(board, x, y - 1, used, word, wordIndex + 1)) {
        return true;
      }
    }

    if (y < board[0].length - 1 && !used[x][y + 1]) {
      if (exist(board, x, y + 1, used, word, wordIndex + 1)) {
        return true;
      }
    }

    used[x][y] = false;

    return false;
  }
}
