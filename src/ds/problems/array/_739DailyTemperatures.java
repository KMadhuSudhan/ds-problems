package ds.problems.array;
//https://leetcode.com/problems/daily-temperatures/
//739. Daily Temperatures

import java.util.Stack;

public class _739DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int size = T.length;
        int [] result = new int[size];
        result[size-1]=0; /* last elment will not have any warmer day */
        stack.add(size-1);

        if(size==1)
            return new int[]{0};

        for(int i=size-2;i>=0;i--){
            while(!stack.isEmpty() && T[stack.peek()]<=T[i] )
                stack.pop();
            if(stack.isEmpty())
                result[i]=0;
            else
                result[i]= stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
}
