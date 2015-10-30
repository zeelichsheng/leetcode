package leetcode.test;

import static org.junit.Assert.*;

import org.junit.Test;

import leetcode.model.AVLTreeNode;

public class AVLTreeNodeTest {

	@Test
	public void testGetHeight_NullTree() {
		int height = AVLTreeNode.getHeight(null);
		
		assertEquals(0, height);
	}
	
	@Test
	public void testGetHeight_NonNullTree() {
		int height = AVLTreeNode.getHeight(new AVLTreeNode(0));
		
		assertEquals(1, height);
	}
	
	@Test
	public void testInsert_NullTree() {
		AVLTreeNode root = AVLTreeNode.insert(null, 5);
		
		assertEquals(5, root.val);
		assertEquals(1, root.height);
	}
	
	@Test
	public void testInsert_LeftInsert() {
		AVLTreeNode root = new AVLTreeNode(5);
		root = AVLTreeNode.insert(root, 4);
		
		assertEquals(5, root.val);
		assertEquals(2, root.height);
		assertEquals(4, root.left.val);
		assertEquals(1, ((AVLTreeNode)root.left).height);
	}
	
	@Test
	public void testInsert_RightInsert() {
		AVLTreeNode root = new AVLTreeNode(5);
		root = AVLTreeNode.insert(root, 6);
		
		assertEquals(5, root.val);
		assertEquals(2, root.height);
		assertEquals(6, root.right.val);
		assertEquals(1, ((AVLTreeNode)root.right).height);
	}
	
	@Test
	public void testInsert_LeftLeftInsert_NoRotation() {
		AVLTreeNode root = new AVLTreeNode(5);
		root = AVLTreeNode.insert(root, 3);
		root = AVLTreeNode.insert(root, 8);
		root = AVLTreeNode.insert(root, 2);
		
		assertEquals(5, root.val);
		assertEquals(3, root.height);
		assertEquals(3, root.left.val);
		assertEquals(2, ((AVLTreeNode)root.left).height);
		assertEquals(8, root.right.val);
		assertEquals(1, ((AVLTreeNode)root.right).height);
		assertEquals(2, root.left.left.val);
		assertEquals(1, ((AVLTreeNode)root.left.left).height);
	}
	
	@Test
	public void testInsert_LeftLeftInsert_Rotation() {
		AVLTreeNode root = new AVLTreeNode(5);
		root = AVLTreeNode.insert(root, 3);
		root = AVLTreeNode.insert(root, 8);
		root = AVLTreeNode.insert(root, 2);
		root = AVLTreeNode.insert(root, 1);

		assertEquals(5, root.val);
		assertEquals(3, root.height);
		assertEquals(2, root.left.val);
		assertEquals(2, ((AVLTreeNode)root.left).height);
		assertEquals(8, root.right.val);
		assertEquals(1, ((AVLTreeNode)root.right).height);
		assertEquals(1, root.left.left.val);
		assertEquals(1, ((AVLTreeNode)root.left.left).height);
		assertEquals(3, root.left.right.val);
		assertEquals(1, ((AVLTreeNode)root.left.right).height);
	}
	
	@Test
	public void testInsert_LeftRightInsert_NoRotation() {
		AVLTreeNode root = new AVLTreeNode(5);
		root = AVLTreeNode.insert(root, 3);
		root = AVLTreeNode.insert(root, 8);
		root = AVLTreeNode.insert(root, 4);
		
		assertEquals(5, root.val);
		assertEquals(3, root.height);
		assertEquals(3, root.left.val);
		assertEquals(2, ((AVLTreeNode)root.left).height);
		assertEquals(8, root.right.val);
		assertEquals(1, ((AVLTreeNode)root.right).height);
		assertEquals(4, root.left.right.val);
		assertEquals(1, ((AVLTreeNode)root.left.right).height);
	}
	
	@Test
	public void testInsert_LeftRightInsert_Rotation() {
		AVLTreeNode root = new AVLTreeNode(6);
		root = AVLTreeNode.insert(root, 3);
		root = AVLTreeNode.insert(root, 7);
		root = AVLTreeNode.insert(root, 2);
		root = AVLTreeNode.insert(root, 4);
		root = AVLTreeNode.insert(root, 5);
		
		assertEquals(4, root.val);
		assertEquals(3, root.height);
		assertEquals(3, root.left.val);
		assertEquals(2, ((AVLTreeNode)root.left).height);
		assertEquals(6, root.right.val);
		assertEquals(2, ((AVLTreeNode)root.right).height);
		assertEquals(2, root.left.left.val);
		assertEquals(1, ((AVLTreeNode)root.left.left).height);
		assertEquals(5, root.right.left.val);
		assertEquals(1, ((AVLTreeNode)root.right.left).height);
		assertEquals(7, root.right.right.val);
		assertEquals(1, ((AVLTreeNode)root.right.right).height);
	}
	
	@Test
	public void testInsert_RightRightInsert_NoRotation() {
		AVLTreeNode root = new AVLTreeNode(5);
		root = AVLTreeNode.insert(root, 3);
		root = AVLTreeNode.insert(root, 6);
		root = AVLTreeNode.insert(root, 7);
		
		assertEquals(5, root.val);
		assertEquals(3, root.height);
		assertEquals(3, root.left.val);
		assertEquals(1, ((AVLTreeNode)root.left).height);
		assertEquals(6, root.right.val);
		assertEquals(2, ((AVLTreeNode)root.right).height);
		assertEquals(7, root.right.right.val);
		assertEquals(1, ((AVLTreeNode)root.right.right).height);
	}
	
	@Test
	public void testInsert_RightRightInsert_Rotation() {
		AVLTreeNode root = new AVLTreeNode(3);
		root = AVLTreeNode.insert(root, 2);
		root = AVLTreeNode.insert(root, 5);
		root = AVLTreeNode.insert(root, 4);
		root = AVLTreeNode.insert(root, 6);
		root = AVLTreeNode.insert(root, 7);
		
		assertEquals(5, root.val);
		assertEquals(3, root.height);
		assertEquals(3, root.left.val);
		assertEquals(2, ((AVLTreeNode)root.left).height);
		assertEquals(6, root.right.val);
		assertEquals(2, ((AVLTreeNode)root.right).height);
		assertEquals(2, root.left.left.val);
		assertEquals(1, ((AVLTreeNode)root.left.left).height);
		assertEquals(4, root.left.right.val);
		assertEquals(1, ((AVLTreeNode)root.left.right).height);
		assertEquals(7, root.right.right.val);
		assertEquals(1, ((AVLTreeNode)root.right.right).height);
	}
	
	@Test
	public void testInsert_RightLeftInsert_NoRotation() {
		AVLTreeNode root = new AVLTreeNode(5);
		root = AVLTreeNode.insert(root, 3);
		root = AVLTreeNode.insert(root, 7);
		root = AVLTreeNode.insert(root, 6);
		
		assertEquals(5, root.val);
		assertEquals(3, root.height);
		assertEquals(3, root.left.val);
		assertEquals(1, ((AVLTreeNode)root.left).height);
		assertEquals(7, root.right.val);
		assertEquals(2, ((AVLTreeNode)root.right).height);
		assertEquals(6, root.right.left.val);
		assertEquals(1, ((AVLTreeNode)root.right.left).height);
	}
	
	@Test
	public void testInsert_RightLeftInsert_Rotation() {
		AVLTreeNode root = new AVLTreeNode(4);
		root = AVLTreeNode.insert(root, 3);
		root = AVLTreeNode.insert(root, 7);
		root = AVLTreeNode.insert(root, 6);
		root = AVLTreeNode.insert(root, 8);
		root = AVLTreeNode.insert(root, 5);
		
		assertEquals(6, root.val);
		assertEquals(3, root.height);
		assertEquals(4, root.left.val);
		assertEquals(2, ((AVLTreeNode)root.left).height);
		assertEquals(7, root.right.val);
		assertEquals(2, ((AVLTreeNode)root.right).height);
		assertEquals(3, root.left.left.val);
		assertEquals(1, ((AVLTreeNode)root.left.left).height);
		assertEquals(5, root.left.right.val);
		assertEquals(1, ((AVLTreeNode)root.left.right).height);
		assertEquals(8, root.right.right.val);
		assertEquals(1, ((AVLTreeNode)root.right.right).height);
		
	}
}
