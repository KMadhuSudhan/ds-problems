package ds.problems.array;
//https://leetcode.com/problems/add-to-array-form-of-integer/submissions/
//989. Add to Array-Form of Integer

import java.util.ArrayList;
import java.util.List;

public class _989AddToArrayFormInteger {

    public static void main(String[] args) {
        _989AddToArrayFormInteger addToArrayFormInteger = new _989AddToArrayFormInteger();
        int[] nums = {0};
        int K = 23;
        addToArrayFormInteger.addToArrayForm(nums,K);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int sum = A[A.length-1] + K%10 ;
        list.add(sum%10);
        int carry = sum  > 9 ? 1 : 0;
        K = K/10;
        for (int i=A.length-2;i>=0;i--) {
            sum = carry +  A[i] + K%10;
            carry = sum  > 9 ? 1 : 0;
            list.add(sum%10);
             K = K == 0 ? 0 : K/10;
        }
        while (K > 0) {
            sum = carry + K%10;
            list.add(sum%10);
            carry = sum > 9 ? 1 : 0;
            K = K == 0 ? 0 : K/10;
        }

        if(carry > 0) {
            list.add(carry);
        }

        List<Integer> result = new ArrayList<>();
        int high = list.size() -1;
        while (high>=0) {
            result.add(list.get(high));
            high--;
        }
        return result;
    }
}
