package ds.problems.array;
//https://leetcode.com/problems/pancake-sorting/
//969. Pancake Sorting

import java.util.ArrayList;
import java.util.List;

public class _969PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();

        int max = Integer.MIN_VALUE;

        boolean sorted = true;

        int end = A.length - 1;
        int tail = 0;

        while(end > 0)
        {
            for(int i = 0; i <= end; i++)
            {
                if(A[i] > max)
                {
                    max = A[i];
                    tail = i;
                }

                if(i < end && A[i] > A[i + 1])
                {
                    sorted = false;
                }
            }

            if(sorted)
            {
                break;
            }
            else
            {
                sorted = true;
                max = Integer.MIN_VALUE;
            }

            reverse(A, tail);
            ans.add(tail + 1);
            ans.add(end + 1);
            reverse(A, end--);
        }

        return ans;
    }

    private void reverse(int[] A, int tail)
    {
        int start = 0;
        int end = tail;

        while(start < end)
        {
            int temp = A[start];
            A[start++] = A[end];
            A[end--] = temp;
        }
    }
}
