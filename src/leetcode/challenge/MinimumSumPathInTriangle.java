package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * 
 * https://leetcode.com/problems/triangle/
 */
public class MinimumSumPathInTriangle {
  public int minimumSum(List<List<Integer>> triangle) {
    List<Integer> calc = new ArrayList<>(triangle.get(triangle.size() - 1));
    
    for (int i = triangle.size() - 2; i >= 0; --i) {
      List<Integer> currRow = triangle.get(i);
      for (int j = 0; j < currRow.size(); ++j) {
        calc.set(j,
            Math.min(calc.get(j) + currRow.get(j), calc.get(j + 1) + currRow.get(j)));
      }
    }
    
    return calc.get(0);
  }
}
