package ds.problems.system.design;
//https://leetcode.com/problems/shuffle-an-array/
//384. Shuffle an Array

import java.util.Random;

public class _384ShuffleAnArray {

    int[] original;
    Random rand;
    public _384ShuffleAnArray(int[] nums) {
        original = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr = original.clone();
        Random random = new Random();
        for(int i = original.length - 1; i >= 0; i --){
            int index = random.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
