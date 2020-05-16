package ds.problems.array;
//https://leetcode.com/problems/single-number-iii/
//260. Single Number III
//need to comeback
public class _SingleNumberIII {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        _SingleNumberIII singleNumberIII = new _SingleNumberIII();
        singleNumberIII.singleNumber(nums);
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i : nums)
            xor ^= i;
        int i = 0;
        while(((xor >> i) & 1) != 1)
            i++;
        int a=0, b=0;
        for(int x : nums){
            if(((x>>i) & 1) == 1)
                a ^= x;
            else
                b ^= x;
        }
        return new int[]{a,b};
    }
}
