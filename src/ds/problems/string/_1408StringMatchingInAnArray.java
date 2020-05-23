package ds.problems.string;
//https://leetcode.com/problems/string-matching-in-an-array/
//1408. String Matching in an Array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _1408StringMatchingInAnArray {
    public static void main(String[] args) {
        _1408StringMatchingInAnArray stringMatchingInAnArray = new _1408StringMatchingInAnArray();
        String[] words = {"mass","as","hero","superhero"};
        System.out.println(stringMatchingInAnArray.stringMatching(words));
    }
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (int i = words.length-1;i>0;i--) {
            for (int j=i-1;j>=0;j--) {
                if(words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
