package leetcode.challenge;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      int k = n % 26;
      if (k == 0) {
        k = 26;
      }

      n /= 26;
      if (k == 26) {
        --n;
      }

      sb.append((char)('A' + k - 1));
    }

    return sb.reverse().toString();
  }
}
