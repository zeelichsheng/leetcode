package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTrees2 {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    
    return generate(1, n);
  }
  
  private List<TreeNode> generate(int start, int end) {
    if (start > end) {
      List<TreeNode> results = new ArrayList<>();
      results.add(null);
      return results;
    }
    
    List<TreeNode> results = new ArrayList<>();
    for (int mid = start; mid <= end; ++mid) {
      List<TreeNode> leftNodes = generate(start, mid - 1);
      List<TreeNode> rightNodes = generate(mid + 1, end);
      
      for (TreeNode leftNode : leftNodes) {
        for (TreeNode rightNode : rightNodes) {
          TreeNode root = new TreeNode(mid);
          root.left = leftNode;
          root.right = rightNode;
          results.add(root);
        }
      }
    }
    
    return results;
  }
}
