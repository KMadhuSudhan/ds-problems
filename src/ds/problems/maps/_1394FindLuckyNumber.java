package ds.problems.maps;
//https://leetcode.com/problems/find-lucky-integer-in-an-array/submissions/
//1394. Find Lucky Integer in an Array

public class _1394FindLuckyNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        _1394FindLuckyNumber  findLuckyNumber = new _1394FindLuckyNumber();
        findLuckyNumber.findLucky(nums);
    }

    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for(int i=0;i<arr.length;i++) {
            freq[arr[i]]++;
        }
        int val = -1;
        for(int i=1;i<=500;i++) {
            if(freq[i] == i) {
                val = Math.max(val,i);
            }
        }
        return val;
    }
}
