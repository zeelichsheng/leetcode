package leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class AddAndSearchWord {
  public static class TrieNode {
    public Map<Character, TrieNode> children;
    
    public TrieNode() {
      children = new HashMap<>();
    }
  }
  
  private TrieNode root;
  
  public AddAndSearchWord() {
    root = new TrieNode();
  }
  
  public void addWord(String word) {
    if (word == null) {
      return;
    }
    
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (!node.children.containsKey(c)) {
        node.children.put(c, new TrieNode());
      }
      
      node = node.children.get(c);
    }
    
    node.children.put('\0', null);    
  }
  
  public boolean search(String word) {
    return search(word, 0, root);
  }
  
  private boolean search(String word, int charIndex, TrieNode node) {
    if (charIndex == word.length()) {
      return node.children.containsKey('\0');
    }
    
    char c = word.charAt(charIndex);
    if (c != '.' && !node.children.containsKey(c)) {
      return false;
    }
    
    if (c != '.') {
      return search(word, charIndex + 1, node.children.get(c));
    }
    
    for (Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
      if (child.getKey() != '\0' && search(word, charIndex + 1, child.getValue())) {
        return true;
      }
    }
    
    return false;
  }
}
