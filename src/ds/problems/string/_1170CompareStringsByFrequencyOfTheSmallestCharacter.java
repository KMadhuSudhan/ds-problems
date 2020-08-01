package ds.problems.string;
//https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
//1170. Compare Strings by Frequency of the Smallest Character

public class _1170CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        for(int i=0;i<queries.length;i++) {
            countFreq(queries[i],q,i);
        }

        for(int i=0;i<words.length;i++) {
            countFreq(words[i],w,i);
        }
        int[] ans = new int[q.length];
        for(int i=0;i<q.length;i++) {
            int count = 0;
            for(int j=0;j<w.length;j++) {
                if(q[i] < w[j]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }


    void countFreq(String word,int[] freq,int index) {
        char[] chars = word.toCharArray();
        int[] cnt = new int[26];
        for(char c: chars) {
            cnt[c - 'a']++;
        }
        for(int i=0;i<26;i++) {
            if(cnt[i]!=0) {
                freq[index] = cnt[i];
                break;
            }
        }
    }
}
