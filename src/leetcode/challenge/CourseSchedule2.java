package leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 * 
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseSchedule2 {
  private static enum Status {
    NEW,
    VISITING,
    VISITED
  }
  
  private List<List<Integer>> graph;
  private Status[] visited;
  private boolean hasLoop;
  private int[] result;
  private int resultIndex;
  
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    result = new int[numCourses];
    if (numCourses == 0) {
      return result;
    }
    
    hasLoop = false;
    resultIndex = 0;
    visited = new Status[numCourses];
    graph = new ArrayList<>();
    
    for (int i = 0; i < numCourses; ++i) {
      graph.add(new ArrayList<>());
    }
    
    for (int i = 0; i < prerequisites.length; ++i) {
      graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    
    for (int i = 0; i < numCourses; ++i) {
      topoSort(i);
    }
    
    return hasLoop ? new int[0] : result;
  }
  
  private void topoSort(int course) {
    if (visited[course] == Status.VISITED || hasLoop) {
      return;
    }
    
    if (visited[course] == Status.VISITING) {
      hasLoop = true;
      return;
    }
    
    visited[course] = Status.VISITING;
    for (Integer prerequisite : graph.get(course)) {
      if (hasLoop) {
        return;
      }
      
      topoSort(prerequisite);
    }
    
    visited[course] = Status.VISITED;
    result[resultIndex++] = course;
  }
}
