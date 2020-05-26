package ds.problems.backtracking;
//https://leetcode.com/problems/binary-watch/
//401. Binary Watch

import java.util.ArrayList;
import java.util.List;

public class _401BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        int[] buffer = new int[60];
        for(int i=0;i<60;i++){
            buffer[i] = countLEDs(i);
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (buffer[i] + buffer[j] == num) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(i);
                    sb.append(":");
                    if(j<=9) {
                        sb.append("0");
                    }
                    sb.append(j);
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    int countLEDs(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n /= 2;
        }
        return count;
    }
}
