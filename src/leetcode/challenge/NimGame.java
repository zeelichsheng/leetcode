package leetcode.challenge;

/**
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the
 * first turn to remove the stones.
 *
 * Both of you are very clever and have optimal strategies for the game. Write a
 * function to determine whether you can win the game given the number of stones
 * in the heap.
 *
 * For example, if there are 4 stones in the heap, then you will never win the
 * game: no matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 *
 * https://leetcode.com/problems/nim-game/
 *
 */
public class NimGame {

  public boolean canWinNim(int n) {
    if (n < 4) {
      return true;
    }

    boolean[] dp = new boolean[n];
    dp[0] = true;
    dp[1] = true;
    dp[2] = true;

    for (int i = 3; i < n; ++i) {
      dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);
    }

    return dp[n - 1];
  }

  public boolean canWinNimSimple(int n) {
    // Given n stones, we use W(n) to represent that player1 wins, and L(n) that
    // player1 loses, then we have a sequence of:
    // W(1)-W(2)-W(3)-L(4)-W(5)-W(6)-W(7)-L(8)-...
    // You can easily see that if n % 4 != 0, then player1 can always take away
    // 1, 2, or 3 stones such that player2 will start in a L position. So as
    // long
    // as player1 does not start in L position (that is n % 4 == 0), player1
    // will win.
    return !(n % 4 == 0);
  }
}
