package ds.problems.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] chars = new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'};
        taskScheduler.leastInterval(chars,2);
    }
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int count = 0,totalCount = 0;
        Set<Character> set = new HashSet();
        for(char ch: tasks) {
            cnt[ch - 'A']++;
            set.add(ch);
        }
        boolean processedTask = true;
        while(processedTask) {
            count = 0;
            for(Character ch : set) {
                int idx = ch - 'A';
                if(cnt[idx]>0) {
                    count++;
                    cnt[idx]--;
                }
            }
            if(count == 0) {
                processedTask = false;
            } else {
                totalCount += count >= n ? count : count + (n - count);
            }
        }
        return totalCount;
    }
}
