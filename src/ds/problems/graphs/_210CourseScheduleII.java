package ds.problems.graphs;
//https://leetcode.com/problems/course-schedule-ii/
//210. Course Schedule II

import java.util.ArrayList;
import java.util.List;

public class _210CourseScheduleII {

    boolean cycle = false;
    int index = 0;
    int[] ans;

    public static void main(String[] args) {
        _210CourseScheduleII courseScheduleII = new _210CourseScheduleII();
        int[][] prerequisites = new int[][] {
                {0,1},
                {1,0}
        };
        courseScheduleII.findOrder(2,prerequisites);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans = new int[numCourses];
        if(prerequisites.length==0){
            for(int i=0;i<numCourses;i++){
                ans[i] = i;
            }
            return ans;
        }
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for (int i=0;i<numCourses;i++) {
            if(!visited[i]) {
                topologicalSort(stack,graph,visited,i);
                if(cycle) {
                    return new int[]{};
                }
            }
        }
        return ans;
    }

    void topologicalSort(boolean[] stack,List<Integer>[] graph,boolean[] visited,int i) {
        if(visited[i]) {
            return;
        }
        else if(stack[i]) {
            cycle = true;
            return;
        } else {
            stack[i] = true;
            for (int course: graph[i]) {
                topologicalSort(stack,graph,visited, course);
            }
            ans[index++] = i;
            visited[i] = true;
        }
    }
}
