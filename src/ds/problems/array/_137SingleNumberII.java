package ds.problems.array;
//https://leetcode.com/problems/single-number-ii/
//137. Single Number II

//need to come back
public class _137SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int num : nums) {
                if((num & (1 << i)) != 0)
                    count++;
            }
            result |= ((count % 3) << i);
        }
        return result;
    }
}
