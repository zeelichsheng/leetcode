package leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {
  public int compareVersion(String version1, String version2) {
    List<String> v1Splits = new ArrayList<>(Arrays.asList(version1.split("\\.")));
    List<String> v2Splits = new ArrayList<>(Arrays.asList(version2.split("\\.")));

    if (v1Splits.size() < v2Splits.size()) {
      fill(v1Splits, v2Splits.size() - v1Splits.size());
    } else if (v1Splits.size() > v2Splits.size()) {
      fill(v2Splits, v1Splits.size() - v2Splits.size());
    }

    for (int i = 0; i < v1Splits.size(); ++i) {
      int v1 = Integer.parseInt(v1Splits.get(i));
      int v2 = Integer.parseInt(v2Splits.get(i));

      if (v1 == v2) {
        continue;
      } else if (v1 < v2) {
        return -1;
      } else {
        return 1;
      }
    }

    return 0;
  }

  private void fill(List<String> splits, int diff) {
    while (diff > 0) {
      splits.add("0");
      --diff;
    }
  }
}
