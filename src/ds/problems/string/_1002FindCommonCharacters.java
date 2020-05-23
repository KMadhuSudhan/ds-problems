package ds.problems.string;
//https://leetcode.com/problems/find-common-characters/
//1002. Find Common Characters

import java.util.ArrayList;
import java.util.List;

public class _1002FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList();
        for(char character: A[0].toCharArray()) {
            boolean repeatedInAll = true;
            String strChar =  Character.toString(character);
            for(int i=1;i<A.length;i++) {
                if(!A[i].contains(strChar)) {
                    repeatedInAll = false;
                    break;
                } else {
                    A[i] = A[i].replaceFirst(strChar,"");
                }
            }
            if(repeatedInAll) {
                ans.add(strChar);
            }
        }
        return ans;
    }
}
