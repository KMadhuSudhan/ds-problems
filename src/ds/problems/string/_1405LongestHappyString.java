package ds.problems.string;
//https://leetcode.com/problems/longest-happy-string/
//1405. Longest Happy String

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1405LongestHappyString {
    public static void main(String[] args) {
        _1405LongestHappyString longestHappyString = new _1405LongestHappyString();
        longestHappyString.longestDiverseString(1,1,7);
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        pq.add(new Pair<>('a',a));
        pq.add(new Pair<>('b',b));
        pq.add(new Pair<>('c',c));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        char re = ' ';

        while (!pq.isEmpty()) {
            Pair<Character, Integer> pair = pq.poll();
            int count = pair.getValue();
            int N = sb.length();
            char ch = pair.getKey();
            if(count == 0) {
                continue;
            }
            if(N<=1) {
                sb.append(ch);
                pq.add(new Pair<>(ch,count-1));
            } else if(sb.charAt(N-1) == ch && sb.charAt(N-2) == ch) {
                re = ch;
                cnt = count;
            } else {
                sb.append(ch);
                pq.offer(new Pair<>(ch,count - 1));
                if(cnt > 0){
                    pq.offer(new Pair<>(re,cnt));
                    cnt = 0;
                }
            }
        }
        return sb.toString();
    }
}
