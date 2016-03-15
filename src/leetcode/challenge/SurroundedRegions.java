package leetcode.challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
  private static final Point[] Directions = new Point[] {
      new Point(-1, 0),
      new Point(1, 0),
      new Point(0, -1),
      new Point(0, 1)
  };
  
  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    
    for (int y = 0; y < board[0].length; ++y) {
      if (board[0][y] == 'O') {
        exploreAndMark(board, 0, y);
      }
      
      if (board[board.length - 1][y] == 'O') {
        exploreAndMark(board, board.length - 1, y);
      }
    }
    
    for (int x = 0; x < board.length; ++x) {
      if (board[x][0] == 'O') {
        exploreAndMark(board, x, 0);
      }
      
      if (board[x][board[0].length - 1] == 'O') {
        exploreAndMark(board, x, board[0].length - 1);
      }
    }
    
    for (int x = 0; x < board.length; ++x) {
      for (int y = 0; y < board[0].length; ++y) {
        if (board[x][y] == 'O') {
          board[x][y] = 'X';
        } else if (board[x][y] == 'B') {
          board[x][y] = 'O';
        }
      }
    }
  }
  
  private void exploreAndMark(char[][] board, int x, int y) {
    Queue<Point> deque = new LinkedList<>();
    board[x][y] = 'B';
    deque.offer(new Point(x, y));    
    
    while (!deque.isEmpty()) {
      Point p = deque.poll();
      for (Point direction : Directions) {
        x = p.x + direction.x;
        y = p.y + direction.y;
        
        if (x >= 0 && x < board.length &&
            y >= 0 && y < board[0].length &&
            board[x][y] == 'O') {
          board[x][y] = 'B';
          deque.offer(new Point(x, y));
        }
      }
    }
  }
  
  private static class Point {
    public int x;
    public int y;
    
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
