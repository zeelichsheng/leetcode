package leetcode.challenge;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * Given an array of strings, group anagrams together.
 * 
 * https://leetcode.com/problems/anagrams/
 */
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> hash = new HashMap<>();
    
    for (String str : strs) {
      char[] c = str.toCharArray();
      Arrays.sort(c);
      String newStr = new String(c);
      
      if (!hash.containsKey(newStr)) {
        hash.put(newStr, new ArrayList<>());
      }
      hash.get(newStr).add(str);
    }
    
    for (List<String> entry : hash.values()) {
      Collections.sort(entry);
      result.add(entry);
    }
    
    return result;
  }
}
