package ds.problems.trees;
//https://leetcode.com/problems/binary-prefix-divisible-by-5/
//1018. Binary Prefix Divisible By 5

import java.util.ArrayList;
import java.util.List;

public class _1018BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        if(A == null || A.length <= 0) return null;
        int num = 0;
        List<Boolean> list = new ArrayList<>();
        for(int i : A){
            num = (num * 2 + i) % 5;
            if(num == 0) list.add(true);
            else list.add(false);
        }
        return list;
    }
}
