package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) {
      return result;
    }
    
    List<Integer> lastRow = new ArrayList<>();
    lastRow.add(1);
    result.add(lastRow);
    
    for (int i = 1; i < numRows; ++i) {
      List<Integer> currRow = new ArrayList<>();
      currRow.add(1);
      for (int j = 1; j < i; ++j) {
        currRow.add(lastRow.get(j - 1) + lastRow.get(j));
      }
      currRow.add(1);
      
      result.add(currRow);
      lastRow = currRow;
    }
    
    return result;
  }
}
