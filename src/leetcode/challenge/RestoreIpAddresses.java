package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {
  public List<String> restoreIpAddresses(String s) {
    Stack<String> cache = new Stack<>();
    List<String> result = new ArrayList<>();
    restore(s, 0, cache, result);
    return result;
  }
  
  private void restore(String s, int startIndex, Stack<String> cache, List<String> result) {    
    if (startIndex >= s.length() && cache.size() != 4) {
      return;
    }
    
    if (startIndex < s.length() && cache.size() == 4) {
      return;
    }
    
    if (startIndex == s.length() && cache.size() == 4) {
      result.add(cache.stream().collect(Collectors.joining(".")));
      return;
    }
    
    int maxEndIndex = Math.min(startIndex + 3, s.length());
    for (int i = startIndex; i < maxEndIndex; ++i) {
      String section = s.substring(startIndex, i + 1);
      int sectionInt = Integer.parseInt(section);
      if (sectionInt > 255) {
        continue;
      }
      
      if (section.length() > 1 && section.startsWith("0")) {
        continue;
      }
      
      cache.push(section);
      restore(s, i + 1, cache, result);
      cache.pop();
    }
  }
}
