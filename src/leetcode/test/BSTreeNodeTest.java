package leetcode.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.BSTreeNode;

public class BSTreeNodeTest {

  @Test
  public void testGetPredecessor_NullNodeIsPredecessor() {
    BSTreeNode root = new BSTreeNode(5);
    BSTreeNode predecessor = root.getPredecessor();

    assertEquals(null, predecessor);
  }

  @Test
  public void testGetPredecessor_LeftNodeIsPredecessor_NullSubLeft() {
    BSTreeNode root = new BSTreeNode(5);
    root = BSTreeNode.insert(root, 4);
    root = BSTreeNode.insert(root, 6);
    BSTreeNode predecessor = root.getPredecessor();

    assertEquals(4, predecessor.val);
  }

  @Test
  public void testGetPredecessor_LeftNodeIsPredecessor_NotNullSubLeft() {
    BSTreeNode root = new BSTreeNode(8);
    root = BSTreeNode.insert(root, 7);
    root = BSTreeNode.insert(root, 6);
    root = BSTreeNode.insert(root, 9);
    BSTreeNode predecessor = root.getPredecessor();

    assertEquals(7, predecessor.val);
  }

  @Test
  public void testGetPredecessor_SubLeftRightNodeIsPredecessor_NullSubLeftLeft() {
    BSTreeNode root = new BSTreeNode(8);
    root = BSTreeNode.insert(root, 5);
    root = BSTreeNode.insert(root, 6);
    BSTreeNode predecessor = root.getPredecessor();

    assertEquals(6, predecessor.val);
  }

  @Test
  public void testGetPredecessor_SubLeftRightNodeIsPredecessor_NotNullSubLeftLeft() {
    BSTreeNode root = new BSTreeNode(8);
    root = BSTreeNode.insert(root, 5);
    root = BSTreeNode.insert(root, 4);
    root = BSTreeNode.insert(root, 6);
    BSTreeNode predecessor = root.getPredecessor();

    assertEquals(6, predecessor.val);
  }

  @Test
  public void testGetSuccessor_NullNodeIsSuccessor() {
    BSTreeNode root = new BSTreeNode(5);
    BSTreeNode successor = root.getSuccessor();

    assertEquals(null, successor);
  }

  @Test
  public void testGetSuccessor_RightNodeIsSuccessor_NullSubRight() {
    BSTreeNode root = new BSTreeNode(5);
    root = BSTreeNode.insert(root, 4);
    root = BSTreeNode.insert(root, 6);
    BSTreeNode successor = root.getSuccessor();

    assertEquals(6, successor.val);
  }

  @Test
  public void testGetSuccessor_RightNodeIsSuccessor_NotNullSubRight() {
    BSTreeNode root = new BSTreeNode(5);
    root = BSTreeNode.insert(root, 4);
    root = BSTreeNode.insert(root, 6);
    root = BSTreeNode.insert(root, 7);
    BSTreeNode successor = root.getSuccessor();

    assertEquals(6, successor.val);
  }

  @Test
  public void testGetSuccessor_SubRightLeftNodeIsSuccessor_NullSubRightRight() {
    BSTreeNode root = new BSTreeNode(4);
    root = BSTreeNode.insert(root, 6);
    root = BSTreeNode.insert(root, 5);
    BSTreeNode successor = root.getSuccessor();

    assertEquals(5, successor.val);
  }

  @Test
  public void testGetSuccessor_SubRightLeftNodeIsSuccessor_NotNullSubRightRight() {
    BSTreeNode root = new BSTreeNode(4);
    root = BSTreeNode.insert(root, 6);
    root = BSTreeNode.insert(root, 5);
    root = BSTreeNode.insert(root, 7);
    BSTreeNode successor = root.getSuccessor();

    assertEquals(5, successor.val);
  }
}
