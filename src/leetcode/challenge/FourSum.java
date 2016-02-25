package leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that
 * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 3;) {
      for (int j = i + 1; j < nums.length - 2;) {
        for (int m = j + 1, n = nums.length - 1; m < n;) {
          int sum = nums[i] + nums[j] + nums[m] + nums[n];
          if (sum == target) {
            result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
            int k = m + 1;
            while (k < n && nums[k] == nums[m]) {
              ++k;
            }
            m = k;

            k = n - 1;
            while (k > m && nums[k] == nums[n]) {
              --k;
            }
            n = k;
          } else if (sum < target) {
            ++m;
          } else {
            --n;
          }
        }

        int k = j + 1;
        while (k < nums.length - 2 && nums[k] == nums[j]) {
          ++k;
        }
        j = k;
      }

      int k = i + 1;
      while (k < nums.length - 3 && nums[k] == nums[i]) {
        ++k;
      }
      i = k;
    }

    return result;
  }
}
