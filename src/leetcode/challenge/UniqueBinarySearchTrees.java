package leetcode.challenge;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; ++i) {
      for (int j = 0; j < i; ++j) {
        // When there are i nodes, dp[j] is the number of possible BST on the left where the size of the
        // left sub-tree is j, and dp[i - j - 1] is the number of possible BST on the right where the size
        // of the right sub-tree is i - j - 1 (1 is for the middle node).
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    
    return dp[n];
  }
}
