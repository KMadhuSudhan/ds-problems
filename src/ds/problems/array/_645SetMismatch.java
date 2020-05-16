package ds.problems.array;
//https://leetcode.com/problems/set-mismatch/
//645. Set Mismatch

public class _645SetMismatch {

    public static void main(String[] args) {
        _645SetMismatch setMismatch = new _645SetMismatch();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        setMismatch.findErrorNums(nums);
    }

    public int[] findErrorNums(int[] nums) {
        int[] temp =new int[nums.length+1];
        int dup=0;
        for(int i =0; i < nums.length; i++){
            if(temp[nums[i]] !=0){
                dup = nums[i];
            }else{
                temp[nums[i]] = nums[i];
            }
        }

        for(int i=1; i < temp.length; i++){
            if(temp[i] ==0){
                return new int[]{dup, i};
            }
        }

        return new int[]{-1, -1};
    }
}
