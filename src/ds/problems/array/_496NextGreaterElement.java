package ds.problems.array;
//https://leetcode.com/problems/next-greater-element-i/
//496. Next Greater Element I

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _496NextGreaterElement {
    public static void main(String[] args) {
        _496NextGreaterElement nextGreaterElement = new _496NextGreaterElement();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        nextGreaterElement.nextGreaterElement(nums1,nums2);
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result [] = new int [nums1.length];
        HashMap<Integer,Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();

        for(int i = 0 ; i < nums2.length ; i++)
        {
            while(!stack.isEmpty() && nums2[i] > stack.peek())
            {
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
            map.put(nums2[i], map.getOrDefault(nums2[i],-1));
        }


        // Once we have the next greater elements we just iterate nums1 and populate result

        for(int i = 0 ; i < nums1.length; i++)
        {
            result [i] = map.getOrDefault(nums1[i],-1);
        }

        return result;
    }
}
