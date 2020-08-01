package ds.problems.math;
//https://leetcode.com/problems/sequential-digits/
//1291. Sequential Digits

import java.util.ArrayList;
import java.util.List;

public class _1291SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();
        List<Integer> result = new ArrayList<Integer>();
        int temp;

        for (int i = lowLength; i <= highLength; i++) {
            for(int j = 0; j <= s.length() - i; j++) {
                temp = Integer.parseInt(s.substring(j, j+i));
                if(temp >= low && temp <= high) {
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
