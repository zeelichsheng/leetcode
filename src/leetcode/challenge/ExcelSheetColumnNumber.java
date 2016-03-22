package leetcode.challenge;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {
  public int titleToNumber(String s) {
    int result = 0;
    for (char c : s.toCharArray()) {
      int curr = c - 'A' + 1;
      result = result * 26 + curr;
    }

    return result;
  }
}
