package leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumberArrangement {
  public String largestNumber(int[] nums) {
    Integer[] sortedNums = new Integer[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      sortedNums[i] = nums[i];
    }
    Arrays.sort(sortedNums, new NumComparator());

    StringBuilder sb = new StringBuilder();
    for (int i = sortedNums.length - 1; i >= 0; --i) {
      sb.append(sortedNums[i]);
    }

    return sb.toString().replaceFirst("^0+(?!$)", "");
  }

  private static class NumComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
      String as = String.valueOf(a);
      String bs = String.valueOf(b);
      String ab = as + bs;
      String ba = bs + as;

      for (int i = 0; i < ab.length(); ++i) {
        char abc = ab.charAt(i);
        char bac = ba.charAt(i);

        if (abc == bac) {
          continue;
        } else if (abc > bac) {
          return 1;
        } else {
          return -1;
        }
      }

      return 0;
    }
  }
}
