package ds.problems.array;
//https://leetcode.com/problems/self-dividing-numbers/
//728. Self Dividing Numbers

import java.util.ArrayList;
import java.util.List;

public class _728SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        if(left <=9) {
            ans.add(left++);
        }
        while(left<=right) {
            if(isDivisable(left)) {
                ans.add(left);
            }
            left++;
        }
        return ans;
    }

    boolean isDivisable(int n) {
        int p = n;
        while(p!=0) {
            int r = p%10;
            if(r == 0 || n%r!=0) {
                return false;
            }
            p/=10;
        }
        return true;
    }
}
