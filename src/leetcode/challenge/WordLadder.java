package leetcode.challenge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length
 * of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * 
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    Deque<String> deque = new LinkedList<>();
    deque.addLast(beginWord);
    wordList.add(endWord);
    int length = 1;
    
    while (!deque.isEmpty()) {
      int size = deque.size();
      ++length;
      for (int i = 0; i < size; ++i) {
        String s = deque.removeFirst();
        char[] sc = s.toCharArray();
        for (int j = 0; j < sc.length; ++j) {
          char c = sc[j];
          for (int k = 0; k < 26; ++k) {            
            sc[j] = (char)(k + 'a');
            String ss = new String(sc);
            if (ss.equals(endWord)) {
              return length;
            }
            
            if (wordList.contains(ss)) {
              deque.add(ss);
              wordList.remove(ss);
            }
          }
          sc[j] = c;
        }
      }
    }
    
    return 0;
  }
}
