package leetcode.challenge;

import leetcode.model.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, 0, inorder.length - 1,
        postorder, 0, postorder.length - 1);
  }
  
  private TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd,
      int[] postorder, int postorderStart, int postorderEnd) {
    if (postorderStart > postorderEnd) {
      return null;
    }
    
    int rootVal = postorder[postorderEnd];
    int j = 0;
    while (j <= inorderEnd - inorderStart) {
      if (inorder[inorderStart + j] == rootVal) {
        break;
      }
      
      ++j;
    }
    
    TreeNode root = new TreeNode(rootVal);
    root.left = buildTree(inorder, inorderStart, inorderStart + j - 1,
        postorder, postorderStart, postorderStart + j - 1);
    root.right = buildTree(inorder, inorderStart + j + 1, inorderEnd,
        postorder, postorderStart + j, postorderEnd - 1);
    
    return root;
  }
}
