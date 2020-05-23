package ds.problems.array;
//https://leetcode.com/problems/trapping-rain-water/
//42. Trapping Rain Water

public class _42TrappingRainWater {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            if(height[left] < height[right]) {
                if(leftMax < height[left]) {
                    leftMax = height[left];
                }
                result += leftMax - height[left];
                left++;
            } else {
                if(rightMax < height[right]) {
                    rightMax = height[right];
                }
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
