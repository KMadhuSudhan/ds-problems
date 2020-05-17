package ds.problems.sortings;
//https://leetcode.com/problems/sort-colors/
//75. Sort Colors


public class _75SortColor {
    public static void main(String[] args) {
        _75SortColor sortColor = new _75SortColor();
        int[] nums = {2,0,2,1,1,0};
         sortColor.sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int high = nums.length-1,low=0,mid=0;
        while (mid<high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums,mid,high);
                    high--;
                    break;
            }
        }
    }

    void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
