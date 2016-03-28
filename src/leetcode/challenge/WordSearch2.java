package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch2 {
  private static class Trie {
    public Trie[] children;
    public String word;

    public Trie() {
      this.children = new Trie[26];
    }
  }
  public List<String> findWords(char[][] board, String[] words) {
    Trie root = new Trie();
    for (String word : words) {
      addToTrie(root, word);
    }

    List<String> result = new ArrayList<>();
    for (int x = 0; x < board.length; ++x) {
      for (int y = 0; y < board[0].length; ++y) {
        dfs(board, x, y, root, result);
      }
    }
    return result;
  }

  private void addToTrie(Trie root, String word) {
    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (root.children[index] == null) {
        root.children[index] = new Trie();
      }
      root = root.children[index];
    }

    root.word = word;
  }

  private void dfs(char[][] board, int x, int y, Trie root, List<String> result) {
    char c = board[x][y];
    if (c == '#' || root.children[c - 'a'] == null) {
      return;
    }

    root = root.children[c - 'a'];
    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }

    board[x][y] = '#';
    if (x > 0) {
      dfs(board, x - 1, y, root, result);
    }

    if (x < board.length - 1) {
      dfs(board, x + 1, y, root, result);
    }

    if (y > 0) {
      dfs(board, x, y - 1, root, result);
    }

    if (y < board[0].length - 1) {
      dfs(board, x, y + 1, root, result);
    }

    board[x][y] = c;
  }
}
