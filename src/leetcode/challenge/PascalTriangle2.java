package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalTriangle2 {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> lastRow = new ArrayList<>();
    
    lastRow.add(1);
    for (int i = 1; i < rowIndex + 1; ++i) {
      List<Integer> currRow = new ArrayList<>();
      currRow.add(1);
      for (int j = 1; j < i; ++j) {
        currRow.add(lastRow.get(j - 1) + lastRow.get(j));
      }
      currRow.add(1);
      
      lastRow = currRow;
    }
    
    return lastRow;
  }
}
