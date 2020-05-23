package ds.problems.array;
//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
//1299. Replace Elements with Greatest Element on Right Side

public class _1299ReplaceElementswithGreatestElementonRightSide {
    public static void main(String[] args) {
        _1299ReplaceElementswithGreatestElementonRightSide replaceElementswithGreatestElementonRightSide = new _1299ReplaceElementswithGreatestElementonRightSide();
        int[] nums = {17, 18, 5, 4, 6, 1};
        replaceElementswithGreatestElementonRightSide.replaceElements(nums);
    }

    public int[] replaceElements(int[] arr) {
        int max = -1;
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max;

            if (temp > max) {
                max = temp;
            }
        }
        return arr;
    }
}
