package ds.problems.string;
//https://leetcode.com/problems/verifying-an-alien-dictionary/
//953. Verifying an Alien Dictionary

public class _953VerifyinganAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        for (int i=0;i<words.length-1;i++) {
            char[] first = words[i].toCharArray();
            char[] second = words[i+1].toCharArray();
            Character fChar = null;
            Character sChar = null;
            for(int j=0;j<Math.min(first.length,second.length);j++) {
                fChar = first[j];
                sChar = second[j];
                if(fChar!=sChar) break;
            }
            if(fChar == sChar && second.length < first.length) return false;
            if(order.indexOf(fChar) > order.indexOf(sChar)) return false;
        }
        return true;
    }
}
