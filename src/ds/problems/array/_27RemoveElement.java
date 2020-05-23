package ds.problems.array;
//https://leetcode.com/problems/remove-element/
//27. Remove Element

public class _27RemoveElement {
    public static void main(String[] args) {
        _27RemoveElement removeElement = new _27RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        removeElement.removeElement(nums,2);
    }
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i=0; i < nums.length; i++) {
            if(nums[i]!=val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
