package ds.problems.array;
//https://leetcode.com/problems/plus-one/
//66. Plus One

import java.util.ArrayList;
import java.util.List;

public class _66PlusOne {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        _66PlusOne plusOne = new _66PlusOne();
        int[] result = plusOne.plusOne(nums);
        System.out.println(result);
    }

    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int sum = digits[digits.length-1]  + 1 ;
        list.add(sum%10);
        int carry = sum  > 9 ? 1 : 0;
        for (int i=digits.length-2;i>=0;i--) {
            sum = carry +  digits[i];
            carry = sum  > 9 ? 1 : 0;
            list.add(sum%10);
        }
        if(carry > 0) {
            list.add(carry);
        }
        int[] result = new int[list.size()];
        int i = list.size() -1;
        int j=0;
        while (i>=0) {
            result[j++] = list.get(i--);
        }
        return result;
    }
}
