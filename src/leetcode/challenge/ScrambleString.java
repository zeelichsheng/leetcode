package leetcode.challenge;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great"
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * https://leetcode.com/problems/scramble-string/
 */
public class ScrambleString {
  private static final int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
      71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
      193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317,
      331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461,
      463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613,
      617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761,
      769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929,
      937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

  public boolean isScramble(String s1, String s2) {
    int l1 = s1.length();
    int l2 = s2.length();

    if (l1 != l2) {
      return false;
    }

    if (l1 <= 1) {
      return s1.equals(s2);
    }

    if (s1.equals(s2)) {
      return true;
    }

    long a = 1;
    long b = 1;
    long c = 1;

    for (int i = 0; i < l1; ++i) {
      if (i > 0 &&
          a == b &&
          isScramble(s1.substring(0, i), s2.substring(0, i)) &&
          isScramble(s1.substring(i), s2.substring(i))) {
        return true;
      }

      if (i > 0 &&
          a == c &&
          isScramble(s1.substring(0, i), s2.substring(l2 - i)) &&
          isScramble(s1.substring(i), s2.substring(0, l2 - i))) {
        return true;
      }

      a *= primes[s1.charAt(i) - 'A'];
      b *= primes[s2.charAt(i) - 'A'];
      c *= primes[s2.charAt(l2 - i - 1) - 'A'];
    }

    return false;
  }
}
