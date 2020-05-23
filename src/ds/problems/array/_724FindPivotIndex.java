package ds.problems.array;
//https://leetcode.com/problems/find-pivot-index/
//724. Find Pivot Index

public class _724FindPivotIndex {
    public static void main(String[] args) {
        _724FindPivotIndex pivotIndex = new _724FindPivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex.pivotIndex(nums));
    }
    public int pivotIndex(int[] nums) {
        int sum =0,pivotSum = 0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
        }
        for(int i=0;i<nums.length;i++) {
            sum-=nums[i];
            if(pivotSum == sum) {
                return i;
            }
            pivotSum+=nums[i];
        }
        return -1;
    }
}
