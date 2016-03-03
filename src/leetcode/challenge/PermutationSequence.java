package leetcode.challenge;

import java.util.List;
import java.util.ArrayList;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * Given n and k, return the kth permutation sequence.
 *
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {
  public String getPermutation(int n, int k) {
    List<Integer> seq = new ArrayList<>();
    int mul = 1;
    for (int i = 1; i <= n; ++i) {
      seq.add(i);
      mul *= i;
    }
    
    mul /= n;
    --k;
    
    String result = "";
    for (int i = n; i > 0; --i) {
      int index = k / mul;
      k = k % mul;
      mul = i == 1 ? 1 : mul / (i - 1);
      
      int digit = seq.get(index);
      result += (char)(digit + '0');
      seq.remove(index);
    }
    
    return result;
  }
}
