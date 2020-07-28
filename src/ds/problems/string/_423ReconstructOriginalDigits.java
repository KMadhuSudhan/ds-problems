package ds.problems.string;
//https://leetcode.com/problems/reconstruct-original-digits-from-english/
//423. Reconstruct Original Digits from English

import java.util.Arrays;

public class _423ReconstructOriginalDigits {
    public static void main(String[] args) {
        _423ReconstructOriginalDigits reconstructOriginalDigits = new _423ReconstructOriginalDigits();
        System.out.println(reconstructOriginalDigits.originalDigits("esnve"));
    }

    public String originalDigits(String s) {
        int n=s.length();
        if(n == 0)return "";
        int[] num={0,2,4,6,8,1,3,5,7,9};
        String[] word ={"zero","two","four","six","eight","one","three","five","seven","nine"};
        char[] hint={'z','w','u','x','g','o','h','f','s','i'};
        int[] cnt = new int[26];
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray())cnt[c-'a']++;
        for(int i=0;i<=9;i++){
            int idx=hint[i]-'a';
            int count=cnt[idx];
            for(char c: word[i].toCharArray()) {
                cnt[c - 'a']-=count;
            }
            while(count-- > 0)
                ans.append(num[i]);
        }
        char[] chars = ans.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
