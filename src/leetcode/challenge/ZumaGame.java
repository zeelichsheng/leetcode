package leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q:0488 Zuma Game
 *
 * You have a row of balls on the table, colored red(R), yellow(Y), blue(B),
 * green(G), and white(W). You also have several balls in your hand.
 * Each time, you may choose a ball in your hand, and insert it into the
 * row (including the leftmost place and rightmost place). Then, if there
 * is a group of 3 or more balls in the same color touching, remove these
 * balls. Keep doing this until no more balls can be removed.
 * Find the minimal balls you have to insert to remove all the balls on
 * the table. If you cannot remove all the balls, output -1.
 *
 * https://leetcode.com/problems/zuma-game/
 */
public class ZumaGame {
  public int findMinStep(String board, String hand) {
    List<Character> charBoard = new ArrayList<Character>();
    for (char c : board.toCharArray()) {
      charBoard.add(c);
    }

    Map<Character, Integer> mapHand = new HashMap<Character, Integer>();
    mapHand.put('R', 0);
    mapHand.put('Y', 0);
    mapHand.put('B', 0);
    mapHand.put('G', 0);
    mapHand.put('W', 0);
    for (char c : hand.toCharArray()) {
      mapHand.put(c, mapHand.get(c) + 1);
    }

    return findMinStep(charBoard, mapHand);
  }

  private int findMinStep(List<Character> board, Map<Character, Integer> hand) {
    cleanBoard(board);

    if (board.size() == 0) {
      return 0;
    }

    if (isHandEmpty(hand)) {
      return -1;
    }

    int count = 0;
    int step = Integer.MAX_VALUE;
    for (int i = 0; i < board.size(); ++i) {
      char c = board.get(i);
      count++;

      if (i == board.size() - 1 || board.get(i + 1) != c) {
        int missing = 3 - count;

        if (hand.get(c) >= missing) {
          hand.put(c, hand.get(c) - missing);
          List<Character> tmpBoard = new ArrayList<Character>(board);

          for (int j = 0; j < count; ++j) {
            tmpBoard.remove(i - j);
          }

          int tmpStep = findMinStep(tmpBoard, hand);
          if (tmpStep != -1) {
            step = Math.min(step, tmpStep + missing);
          }

          hand.put(c, hand.get(c) + missing);
        }

        count = 0;
      }
    }

    return step == Integer.MAX_VALUE ? -1 : step;
  }

  private void cleanBoard(List<Character> board) {
    int count = 0;
    boolean isCleaned = false;
    for (int i = 0; i < board.size(); ++i) {
      char c = board.get(i);
      ++count;

      if (i == board.size() - 1 || board.get(i + 1) != c) {
        if (count >= 3) {
          for (int j = 0; j < count; ++j) {
            board.remove(i - j);
          }

          isCleaned = true;
          break;
        }

        count = 0;
      }
    }

    if (isCleaned) {
      cleanBoard(board);
    }
  }

  private boolean isHandEmpty(Map<Character, Integer> hand) {
    for (int value : hand.values()) {
      if (value > 0) {
        return false;
      }
    }

    return true;
  }
}
