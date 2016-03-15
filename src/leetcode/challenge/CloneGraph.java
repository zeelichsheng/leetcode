package leetcode.challenge;

import leetcode.model.UndirectedGraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
  public UndirectedGraphNode clone(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }

    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    Set<UndirectedGraphNode> processed = new HashSet<>();
    Queue<UndirectedGraphNode> queue = new LinkedList<>();

    queue.offer(node);
    map.put(node, new UndirectedGraphNode(node.label));

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; ++i) {
        UndirectedGraphNode oldNode = queue.poll();
        if (processed.contains(oldNode)) {
          continue;
        }

        UndirectedGraphNode newNode = map.get(oldNode);

        for (UndirectedGraphNode oldNeighborNode : oldNode.neighbors) {
          if (!map.containsKey(oldNeighborNode)) {
            map.put(oldNeighborNode, new UndirectedGraphNode(oldNeighborNode.label));
          }

          newNode.neighbors.add(map.get(oldNeighborNode));
          queue.offer(oldNeighborNode);
        }

        processed.add(oldNode);
      }
    }

    return map.get(node);
  }
}
