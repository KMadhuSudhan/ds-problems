package ds.problems.system.design;
//https://leetcode.com/problems/product-of-the-last-k-numbers/
//1352. Product of the Last K Numbers

import java.util.ArrayList;
import java.util.List;

public class _1352ProductOftheLastKNumbers {
    List<Integer> list;
    public _1352ProductOftheLastKNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if(num == 0) {
            list = new ArrayList<>();
            list.add(1);
        } else {
            list.add(list.get(list.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = list.size();
        return (k<n) ? list.get(n-1)/list.get(n-k-1): 0;
    }
}
