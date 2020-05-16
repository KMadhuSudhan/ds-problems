package ds.problems.numbers;
//https://leetcode.com/problems/happy-number/
//202. Happy Number

import java.util.HashSet;
import java.util.Set;

public class _202HappyNumber {
    public static void main(String[] args) {
        _202HappyNumber happyNumber = new _202HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(n!=1) {
            int tmp = n;
            int sum = 0;
            while(tmp!=0) {
                int reminder = tmp%10;
                sum+=reminder*reminder;
                tmp/=10;
            }
            if(set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
