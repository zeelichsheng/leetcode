package leetcode.challenge;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {
  public int countPrimes(int n) {
    boolean[] isPrime = new boolean[n];
    for (int i = 2; i < n; ++i) {
      isPrime[i] = true;
    }
        
    for (int i = 2; i * i < n; ++i) {
      if (!isPrime[i]) {
        continue;
      }
      
      for (int j = i * i; j < n; j += i) {
        isPrime[j] = false;
      }
    }
    
    int count = 0;
    for (int i = 2; i < n; ++i) {
      if (isPrime[i]) {
        ++count;
      }
    }
    
    return count;
  }
}
