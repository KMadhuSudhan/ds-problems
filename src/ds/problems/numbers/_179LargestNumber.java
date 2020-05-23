package ds.problems.numbers;
//https://leetcode.com/problems/largest-number/
//179. Largest Number

import java.util.*;

public class _179LargestNumber {
    public static void main(String[] args) {
        _179LargestNumber largestNumber = new _179LargestNumber();
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber.largestNumber(nums));

    }
    // using custom sort
    public String largestNumber(int[] nums) {
        int temp=0;
        for(int x:nums)if(x!=0)temp=1;
        if(temp==0)return "0";
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            list.add(num);
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list,new NumComparator());
        for (int num: list) {
            sb.append(num);
        }
        return sb.toString();
    }
    class NumComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String x = o1+""+o2;
            String y = o2+""+o1;

            //Handle potential integer overflow
            long x_num = Long.parseLong(x);
            long y_num = Long.parseLong(y);

            if (x_num > y_num){
                return -1;
            } else {
                return 1;
            }
        }
    }
    /* using merge sort
    public String largestNumber(int[] nums) {
        int temp=0;
        for(int x:nums)if(x!=0)temp=1;
        if(temp==0)return "0";

        sort(nums,0,nums.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<nums.length;i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    void sort(int[] nums,int low,int high) {
        if(low<high) {
            int mid = (high+low)/2;
            sort(nums,low,mid);
            sort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }

    void merge(int[] nums,int low,int mid,int high) {
        int n1 = mid - low  + 1;
        int n2 = high - mid;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for(int i=0;i<n1;i++){
            a1[i] = nums[low + i];
        }
        for(int i=0;i<n2;i++){
            a2[i] = nums[mid + i  + 1];
        }
        int i=0,j=0,k = low;
        while(i<n1 && j < n2) {
            if(check(a1[i],a2[j])) {
                nums[k++] = a1[i++];
            } else {
                nums[k++] = a2[j++];
            }
        }
        while(i<n1) {
            nums[k++] = a1[i++];
        }
        while(j<n2) {
            nums[k++] = a2[j++];
        }
    }

    boolean check(int n1,int n2) {
        StringBuffer a=new StringBuffer();
        a.append(n1);
        a.append(n2);
        StringBuffer b=new StringBuffer();
        b.append(n2);
        b.append(n1);
        return Long.parseLong(a.toString())>Long.parseLong(b.toString());
    } */
}
