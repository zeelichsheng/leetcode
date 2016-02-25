package leetcode.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    
    List<List<Integer>> result = new ArrayList<>();
    int i = 0;
    int size = nums.length;
    while (i < size - 2) {
      while (i - 1 >= 0 && i < size - 2 && nums[i] == nums[i - 1]) {
        ++i;
      }
      
      int a = nums[i];
      int j = i + 1;
      int k = size - 1;
      while (j < k) {
        int b = nums[j];
        int c = nums[k];
        
        int sum = a + b + c;
        if (sum == 0) {
          List<Integer> lst = new ArrayList<>();
          lst.add(a);
          lst.add(b);
          lst.add(c);
          result.add(lst);
          
          while (j < size && nums[j] == b) {
            ++j;
          }
          
          while (k >= 0 && nums[k] == c) {
            --k;
          }
        } else if (sum < 0) {
          ++j;
        } else {
          --k;
        }
      }
      
      ++i;
    }
    
    return result;
  }
}
