package ds.problems.array;
//https://leetcode.com/problems/reduce-array-size-to-the-half/
//1338. Reduce Array Size to The Half

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _1338ReduceArraySizetoTheHalf {

    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i:arr)
            map.put(i,map.getOrDefault(i,0)+1);

        //if there is only one element in the array we have to remove it only
        //so return 1
        if(map.size()==1)  return 1;

        //if all the elements in the array are unique then we have
        //to remove half of the elements
        if(map.size()==arr.length)  return arr.length/2;

        //list contains all the frequencies of elements in the array
        List<Integer> counts=new ArrayList<>(map.values());

        counts.sort(Comparator.reverseOrder());

        int noOfElements=0;
        //we have to start by removing the element with the maximum freq
        //and then keep counting the no of elements till we reach
        //more than half elements and then return the no of unique
        //numbers we have deleted till now

        //which is the index in the list +1
        for(int i=0;i<counts.size();i++){
            noOfElements+=counts.get(i);
            if(noOfElements>=arr.length/2)
                return i+1;//this denotes the no of unique elements deleted so far
        }
        return 0;
    }

}
