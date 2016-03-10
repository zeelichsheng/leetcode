package leetcode.challenge;

import leetcode.model.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, 0, preorder.length - 1,
        inorder, 0, inorder.length - 1);
  }
  
  private TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
      int[] inorder, int inorderStart, int inorderEnd) {
    if (preorderStart > preorderEnd) {
      return null;
    }
    
    int rootVal = preorder[preorderStart];
    int j = 0;
    while (j <= inorderEnd - inorderStart) {
      if (inorder[inorderStart + j] == rootVal) {
        break;
      }
      
      ++j;
    }

    TreeNode root = new TreeNode(rootVal);
    root.left = buildTree(preorder, preorderStart + 1, preorderStart + j,
        inorder, inorderStart, inorderStart + j - 1);
    root.right = buildTree(preorder, preorderStart + j + 1, preorderEnd,
        inorder, inorderStart + j + 1, inorderEnd);
    
    return root;
  }
}
