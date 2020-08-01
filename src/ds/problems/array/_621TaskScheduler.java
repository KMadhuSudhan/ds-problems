package ds.problems.array;
//https://leetcode.com/problems/task-scheduler/
//621. Task Scheduler

import java.util.Arrays;

public class _621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(char task: tasks) {
            cnt[task - 'A']++;
        }
        Arrays.sort(cnt);
        int max = cnt[25] -1;
        int spaces = max*n;
        for(int i=24;i>=0;i--) {
            spaces-= Math.min(max, cnt[i]);
        }
        spaces = Math.max(0, spaces); //handle when spaces in -ve
        return tasks.length + spaces;
    }
}
