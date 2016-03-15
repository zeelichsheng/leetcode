package leetcode.challenge;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station
 * (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0;
    int totalGas = 0;
    int length = gas.length;

    for (int i = 0; i < length * 2; ++i) {
      int curr = i % length;
      int next = (i + 1) % length;

      if (totalGas + gas[curr] - cost[curr] >= 0) {
        totalGas += gas[curr] - cost[curr];

        if (start == next) {
          return start;
        }
      } else {
        totalGas = 0;
        start = next;
      }
    }

    return -1;
  }
}
