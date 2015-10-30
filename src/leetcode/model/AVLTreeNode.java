package leetcode.model;

public class AVLTreeNode extends BSTreeNode {

  public int height;

  public AVLTreeNode(int val) {
    super(val);
    this.height = 1;
  }

  public static int getHeight(AVLTreeNode node) {
    if (node == null) {
      return 0;
    }

    return node.height;
  }

  public static int getBalanceFactor(AVLTreeNode node) {
    if (node == null) {
      return 0;
    }

    return getHeight((AVLTreeNode) node.left) - getHeight((AVLTreeNode) node.right);
  }

  public static AVLTreeNode insert(AVLTreeNode node, int val) {
    // 1. Perform the normal BST insertion
    if (node == null) {
      return new AVLTreeNode(val);
    }

    if (val < node.val) {
      node.left = insert((AVLTreeNode) node.left, val);
    } else {
      node.right = insert((AVLTreeNode) node.right, val);
    }

    // 2. Update height of this ancestor node
    node.height = Math.max(getHeight((AVLTreeNode) node.left), getHeight((AVLTreeNode) node.right)) + 1;

    // 3. Get the balance factor of this ancestor node to check whether this
    // node
    // became unbalanced
    int balanceFactor = getBalanceFactor(node);

    // Left left
    if (balanceFactor > 1 && val < node.left.val) {
      return rightRotate(node);
    }

    // Left right
    if (balanceFactor > 1 && val > node.left.val) {
      node.left = leftRotate((AVLTreeNode) node.left);
      return rightRotate(node);
    }

    // Right right
    if (balanceFactor < -1 && val > node.right.val) {
      return leftRotate(node);
    }

    // Right left
    if (balanceFactor < -1 && val < node.right.val) {
      node.right = rightRotate((AVLTreeNode) node.right);
      return leftRotate(node);
    }

    // Node balanced
    return node;
  }

  public static AVLTreeNode rightRotate(AVLTreeNode node) {
    AVLTreeNode x = (AVLTreeNode) node.left;
    AVLTreeNode xx = (AVLTreeNode) x.right;

    x.right = node;
    node.left = xx;

    node.height = Math.max(getHeight((AVLTreeNode) node.left), getHeight((AVLTreeNode) node.right)) + 1;
    x.height = Math.max(getHeight((AVLTreeNode) x.left), getHeight((AVLTreeNode) x.right)) + 1;

    return x;
  }

  public static AVLTreeNode leftRotate(AVLTreeNode node) {
    AVLTreeNode x = (AVLTreeNode) node.right;
    AVLTreeNode xx = (AVLTreeNode) x.left;

    x.left = node;
    node.right = xx;

    node.height = Math.max(getHeight((AVLTreeNode) node.left), getHeight((AVLTreeNode) node.right)) + 1;
    x.height = Math.max(getHeight((AVLTreeNode) x.left), getHeight((AVLTreeNode) x.right)) + 1;

    return x;
  }
}
