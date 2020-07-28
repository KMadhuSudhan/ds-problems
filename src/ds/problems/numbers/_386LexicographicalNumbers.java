package ds.problems.numbers;

import java.util.ArrayList;
import java.util.List;

public class _386LexicographicalNumbers {
    List<Integer> ans;
    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList();
        dfs(n,0);
        return ans;
    }
    void dfs(int max,int number) {
        if(number > max) return;
        if(number!=0) {
            ans.add(number);
        }
        for(int i=0;i<10;i++) {
            if(i + number <= 0) continue;
            dfs(max, number * 10 + i);
        }
    }
}
