package leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDnaSequences {
  public List<String> findRepeatedDnaSequences(String s) {
    Map<Integer, Boolean> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    int t = 0;

    for (int i = 0; i < s.length(); ++i) {
      t = ((t << 3) & 0x3FFFFFFF) | (s.charAt(i) & 7);
      if (map.containsKey(t)) {
        if (map.get(t)) {
          result.add(s.substring(i - 9, i + 1));
          map.put(t, false);
        }
      } else {
        map.put(t, true);
      }
    }

    return result;
  }
}
