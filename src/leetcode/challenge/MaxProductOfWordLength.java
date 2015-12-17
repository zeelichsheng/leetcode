package leetcode.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. You may assume that each word will contain
 * only lower case letters. If no such two words exist, return 0.
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */
public class MaxProductOfWordLength {

  /**
   * Finds the maximum of the product of two words in the given word array.
   * @param words
   * @return
   */
  public int maxProduct(String[] words) {
    Collections.sort(Arrays.asList(words), new WordComparator());
    int[] binaries = new int[words.length];
    for (int i = 0; i < words.length; ++i) {
      binaries[i] = strToBinary(words[i]);
    }

    int maxProduct = 0;
    for (int l = 0, r = words.length - 1; l < r; --r) {
      int i = -1;
      for (int nl = l; nl < r; ++nl) {
        if ((binaries[nl] & binaries[r]) == 0) {
          i = nl;
        }
      }

      if (i != -1) {
        maxProduct = Math.max(
            maxProduct,
            words[i].length() * words[r].length());
        l = i + 1;
      }
    }

    return maxProduct;
  }

  private int strToBinary(String word) {
    int b = 0;
    for (char c : word.toCharArray()) {
      b |= 1 << (c - 97);
    }

    return b;
  }

  private static class WordComparator implements Comparator<String> {
    public int compare(String a, String b) {
      return a.length() - b.length();
    }
  }
}
