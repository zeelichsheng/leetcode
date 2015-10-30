package leetcode.model;

public class BSTreeNode extends TreeNode {
  public BSTreeNode(int val) {
    super(val);
  }

  public BSTreeNode getPredecessor() {
    BSTreeNode n = (BSTreeNode) this.left;

    while (n != null && n.right != null) {
      n = (BSTreeNode) n.right;
    }

    return n;
  }

  public BSTreeNode getSuccessor() {
    BSTreeNode n = (BSTreeNode) this.right;

    while (n != null && n.left != null) {
      n = (BSTreeNode) n.left;
    }

    return n;
  }

  public static BSTreeNode insert(BSTreeNode node, int val) {
    if (node == null) {
      return new BSTreeNode(val);
    }

    if (val < node.val) {
      node.left = insert((BSTreeNode) node.left, val);
    } else {
      node.right = insert((BSTreeNode) node.right, val);
    }

    return node;
  }
}
