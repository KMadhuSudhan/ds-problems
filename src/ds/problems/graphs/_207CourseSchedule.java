package ds.problems.graphs;
//https://leetcode.com/problems/course-schedule/
//207. Course Schedule

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class _207CourseSchedule {
    boolean[] visited;
    boolean[] recStack;
    List<Integer>[] graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(isCyclicUtil(i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclicUtil(int i)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = graph[i];

        for (Integer c: children)
            if (isCyclicUtil(c))
                return true;

        recStack[i] = false;

        return false;
    }

}
