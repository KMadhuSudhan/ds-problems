package ds.problems.test;

import java.util.HashSet;
import java.util.Set;

public class PathsToGoal {
    HashSet<String>  set =  new HashSet<String>();
    public static void main(String[] args) {

    }
    private int findWays(String s, int n, int x, int y) {
        helper("rrrlrr".toCharArray(),n,x,y,0,new StringBuilder(),set);
        return set.size();
    }

    private void helper(char[] input, int length, int x, int y,int currentIndex,StringBuilder path,Set<String> set) {
        if(x==y){
            set.add(path.toString());
        }

        if(currentIndex<0 || currentIndex>=length)
            return;

        char c = input[currentIndex];

        helper(input,length,x,y,currentIndex+1,path,set);

        if( c == 'r'){
            if(x+1< length) {
                helper(input, length, x + 1, y, currentIndex + 1, path.append("r"), set);
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            if(x>0) {
                helper(input, length, x - 1, y, currentIndex + 1, path.append("l"), set);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
