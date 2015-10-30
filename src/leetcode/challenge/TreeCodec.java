package leetcode.challenge;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class TreeCodec {

  public String serialize(TreeNode root) {
    List<String> arr = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.pollFirst();

      arr.add(convert(node));
      if (node != null) {
        queue.addLast(node.left);
        queue.addLast(node.right);
      }
    }

    return String.join(",", arr);
  }

  public TreeNode deserialize(String data) {
    String[] arr = data.split(",");
    List<TreeNode> tree = new ArrayList<>();
    for (int i = 0; i < arr.length; ++i) {
      tree.add(convert(arr[i]));
    }

    Deque<TreeNode> queue = new LinkedList<>();
    int index = 0;

    queue.addLast(tree.get(0));
    while (!queue.isEmpty()) {
      TreeNode node = queue.pollFirst();

      if (node != null) {
        TreeNode left = tree.get(++index);
        TreeNode right = tree.get(++index);

        node.left = left;
        node.right = right;

        queue.addLast(left);
        queue.addLast(right);
      }
    }

    return tree.get(0);
  }

  private TreeNode convert(String t) {
    if (t.equals("n")) {
      return null;
    } else {
      return new TreeNode(Integer.parseInt(t));
    }
  }

  private String convert(TreeNode n) {
    if (n == null) {
      return "n";
    } else {
      return String.valueOf(n.val);
    }
  }
}
