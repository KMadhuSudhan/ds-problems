package ds.problems.system.design;
//https://leetcode.com/problems/iterator-for-combination/
//1286. Iterator for Combination

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {

    Queue<String> queue;

    public static void main(String[] args) {

    }
    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        combinations(characters.toCharArray(),0,combinationLength,new StringBuilder());
    }

    public String next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    void combinations(char[] chars,int start,int k,StringBuilder sb) {
          if(sb.length() == k) {
              queue.add(sb.toString());
          }
          for(int i=start;i<chars.length;i++) {
              sb.append(chars[i]);
              combinations(chars,i+1,k,sb);
              sb.deleteCharAt(sb.length() - 1);
          }
    }
}
