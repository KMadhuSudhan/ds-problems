package ds.problems.test;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    //548935

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Permutations permutations = new Permutations();
        System.out.println(permutations.generatePermutations(arr));
    }

    List<List<Integer>> generatePermutations(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        permutations(arr,ans,0);
        return ans;
    }

    void permutations(int[] arr,List<List<Integer>> ans,int start) {
        if(start == arr.length) {
            ans.add(getList(arr));
            return;
        }
        for (int i=start;i<arr.length;i++) {
            swap(arr,start,i);
            permutations(arr,ans,i+1);
            swap(arr,start,i);
        }
    }

    void swap(int[] arr ,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    List<Integer> getList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int num: arr) {
            list.add(num);
        }
        return list;
    }
}

/*
delete * from users group by name,phoneNumber,age having count(*) > 0;
*/