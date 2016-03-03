package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * https://leetcode.com/problems/combinations/
 */
public class KCombinations {
  public List<List<Integer>> combine(int n, int k) {
    Stack<Integer> used = new Stack<>();
    List<List<Integer>> result = new ArrayList<>();
    combine(n, 1, k, used, result);
    return result;
  }

  private void combine(int n, int t, int k, Stack<Integer> used, List<List<Integer>> result) {
    if (k == 0) {
      result.add(new ArrayList<>(used));
      return;
    }

    for (int i = t; i <= n; ++i) {
      used.push(i);
      combine(n, i + 1, k - 1, used, result);
      used.pop();
    }
  }
}
