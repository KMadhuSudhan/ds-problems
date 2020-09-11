package ds.problems.array;
//https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
//1566. Detect Pattern of Length M Repeated K or More Times
public class _1566DetectPatternOfLengthMRepeatedKOrMoreTimes {
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i=0;i<=arr.length-m;i++) {
            int count = 0,freq = 1,start = i;
            for(int j=i+m;j < arr.length;j++) {
                if(arr[j] == arr[start++]) {
                    count++;
                } else {
                    count = 0;
                    start = i;
                    freq = 0;
                }
                if(count == m) {
                    freq++;
                    count = 0;
                    start = i;
                }
                if(freq >= k) return true;
            }
        }
        return false;
    }
}
