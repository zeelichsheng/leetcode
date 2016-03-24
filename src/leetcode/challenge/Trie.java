package leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {
  public static class TrieNode {
    public Map<Character, TrieNode> children;
    
    public TrieNode() {
      children = new HashMap<>();
    }
  }
  
  private TrieNode root;
  
  public Trie() {
    root = new TrieNode();
  }
  
  public void insert(String word) {
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
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (!node.children.containsKey(c)) {
        return false;
      }
      
      node = node.children.get(c);
    }
    
    return node.children.containsKey('\0');
  }
  
  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
      if (!node.children.containsKey(c)) {
        return false;
      }
      
      node = node.children.get(c);
    }
    
    return true;
  }
}
