package ds.problems.string;
//https://leetcode.com/problems/buddy-strings
//859. Buddy Strings

import java.util.HashSet;
import java.util.Set;

public class _859BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if(A.length() == 0 && B.length() == 0) return false;
        if(A.length()!=B.length()) {
            return false;
        }
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();

        if(A.equals(B)) {
            Set<Character> set = new HashSet();
            for(int i=0;i<aChars.length;i++) {
                set.add(aChars[i]);
            }
            return set.size() != aChars.length;
        }

        int[] indexes = new int[2];
        int count = 0;
        for (int i=0;i<aChars.length;i++) {
            if(count == 2 && aChars[i]!=bChars[i]) return false;
            if(aChars[i]!=bChars[i]) {
                indexes[count++] = i;
            }
        }
        char tmp = aChars[indexes[0]];
        aChars[indexes[0]] = aChars[indexes[1]];
        aChars[indexes[1]] = tmp;
        String aString = new String(aChars);
        String bString = new String(bChars);
        return aString.equals(bString);
    }
}
