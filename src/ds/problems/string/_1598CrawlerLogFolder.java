package ds.problems.string;
//https://leetcode.com/problems/crawler-log-folder/
//1598. Crawler Log Folder

public class _1598CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int ans = 0;
        for(int i=0;i<logs.length;i++) {
            String log = logs[i];
            if(log.equals("./")) {
                continue;
            } else if(log.equals("../")) {
                if(ans>0){
                    ans--;
                }
            } else {
                ans++;
            }
        }
        return ans>=0 ? ans : 0;
    }
}
