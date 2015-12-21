package leetcode.challenge;

/**
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For
 * example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given
 * primes = [2, 7, 13, 19] of size 4.
 *
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 *
 * https://leetcode.com/problems/super-ugly-number/
 */
public class SuperUglyNumber {

  /**
   * Finds the nth super ugly number.
   * @param n
   * @param primes
   * @return
   */
  public int nthSuperUglyNumber(int n, int[] primes) {
    if (n <= 0 || primes == null || primes.length == 0) {
      return 0;
    }

    int[] result = new int[n];
    int numOfPrimes = primes.length;
    int[] pointers = new int[numOfPrimes];

    for (int i = 0; i < numOfPrimes; ++i) {
      pointers[i] = 0;
    }

    result[0] = 1;
    for (int i = 1; i < n; ++i) {
      int nextValue = primes[0] * result[pointers[0]];
      for (int j = 1; j < numOfPrimes; ++j) {
        nextValue = Math.min(nextValue, primes[j] * result[pointers[j]]);
      }

      for (int j = 0; j < numOfPrimes; ++j) {
        if (nextValue == primes[j] * result[pointers[j]]) {
          ++pointers[j];
        }
      }

      result[i] = nextValue;
    }

    return result[n - 1];
  }
}
