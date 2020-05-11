package ds.problems.array;
//https://leetcode.com/problems/max-consecutive-ones/
//485. Max Consecutive Ones

public class _485MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        _485MaxConsecutiveOnes maxConsecutiveOnes = new _485MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,i=0,size=0;
        while(i<nums.length) {
            while (i < nums.length &&  nums[i] == 1) {
                size++;
                i++;
            }
            if(size == 0) i++;
            max = Math.max(max, size);
            size = 0;
        }
        return max;
    }
}
