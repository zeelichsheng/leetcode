package leetcode.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import leetcode.challenge.TreeCodec;
import leetcode.model.TreeNode;

public class TreeCodecTest {

  private static TreeCodec codec;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    codec = new TreeCodec();
  }

  @Test
  public void testSerialize_EmptyTree() {
    TreeNode node = null;
    String result = codec.serialize(node);

    assertEquals("n", result);
  }

  @Test
  public void testSerialize_LeftRightNullTree() {
    TreeNode node = new TreeNode(1);
    String result = codec.serialize(node);

    assertEquals("1,n,n", result);
  }

  @Test
  public void testSerialize_LeftNullTree() {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    node1.left = null;
    node1.right = node2;
    String result = codec.serialize(node1);

    assertEquals("1,n,2,n,n", result);
  }

  @Test
  public void testSerialize_RightNullTree() {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    node1.left = node2;
    node1.right = null;
    String result = codec.serialize(node1);

    assertEquals("1,2,n,n,n", result);
  }

  @Test
  public void testSerialize_FullTree() {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    node1.left = node2;
    node1.right = node3;
    String result = codec.serialize(node1);

    assertEquals("1,2,3,n,n,n,n", result);
  }

  @Test
  public void testSerialize_ComplexTree() {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    node1.left = node2;
    node1.right = node3;
    node2.right = node4;
    node3.left = node5;
    node3.right = node6;
    node6.left = node7;
    String result = codec.serialize(node1);

    assertEquals("1,2,3,n,4,5,6,n,n,n,n,7,n,n,n", result);
  }

  @Test
  public void testDeserialize_EmptyTree() {
    TreeNode root = codec.deserialize("n");

    assertEquals(null, root);
  }

  @Test
  public void testDeserialize_LeftRightNullTree() {
    TreeNode root = codec.deserialize("1,n,n");

    assertEquals(1, root.val);
    assertEquals(null, root.left);
    assertEquals(null, root.right);
  }

  @Test
  public void testDeserialize_LeftNullTree() {
    TreeNode root = codec.deserialize("1,n,2,n,n");

    assertEquals(1, root.val);
    assertEquals(null, root.left);
    assertEquals(2, root.right.val);
    assertEquals(null, root.right.left);
    assertEquals(null, root.right.right);
  }

  @Test
  public void testDeserialize_RightNullTree() {
    TreeNode root = codec.deserialize("1,2,n,n,n");

    assertEquals(1, root.val);
    assertEquals(2, root.left.val);
    assertEquals(null, root.right);
    assertEquals(null, root.left.left);
    assertEquals(null, root.left.right);
  }

  @Test
  public void testDeserialize_FullTree() {
    TreeNode root = codec.deserialize("1,2,3,n,n,n,n");

    assertEquals(1, root.val);
    assertEquals(2, root.left.val);
    assertEquals(3, root.right.val);
    assertEquals(null, root.left.left);
    assertEquals(null, root.left.right);
    assertEquals(null, root.right.left);
    assertEquals(null, root.right.right);
  }

  @Test
  public void testDeserialize_CompexTree() {
    TreeNode root = codec.deserialize("1,2,3,n,4,5,6,n,n,n,n,7,n,n,n");

    assertEquals(1, root.val);
    assertEquals(2, root.left.val);
    assertEquals(3, root.right.val);
    assertEquals(null, root.left.left);
    assertEquals(4, root.left.right.val);
    assertEquals(5, root.right.left.val);
    assertEquals(6, root.right.right.val);
    assertEquals(null, root.left.right.left);
    assertEquals(null, root.left.right.right);
    assertEquals(null, root.right.left.left);
    assertEquals(null, root.right.left.right);
    assertEquals(7, root.right.right.left.val);
    assertEquals(null, root.right.right.right);
    assertEquals(null, root.right.right.left.left);
    assertEquals(null, root.right.right.left.right);
  }
}
