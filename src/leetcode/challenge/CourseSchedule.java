package leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.model.UndirectedGraphNode;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
    for (int i = 0; i < numCourses; ++i) {
      nodeMap.put(i, new UndirectedGraphNode(i));
    }
    
    for (int i = 0; i < prerequisites.length; ++i) {
      nodeMap.get(prerequisites[i][0]).neighbors.add(nodeMap.get(prerequisites[i][1]));
    }
    
    Set<UndirectedGraphNode> visited = new HashSet<>();
    for (UndirectedGraphNode node : nodeMap.values()) {
      if (visited.contains(node)) {
        continue;
      }
            
      Set<UndirectedGraphNode> path = new HashSet<>();
      if (hasLoop(node, path, visited)) {
        return false;
      }
    }
    
    return true;
  }
  
  private boolean hasLoop(UndirectedGraphNode node, Set<UndirectedGraphNode> path,
      Set<UndirectedGraphNode> visited) {
    if (path.contains(node)) {
      return true;
    }
    
    path.add(node);
    visited.add(node);
    for (UndirectedGraphNode neighbor : node.neighbors) {
      if (hasLoop(neighbor, path, visited)) {
        return true;
      }
    }
    path.remove(node);    
    return false;
  }
}
