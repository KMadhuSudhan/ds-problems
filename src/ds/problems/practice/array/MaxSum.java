package ds.problems.practice.array;

public class MaxSum {
    public  static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        System.out.println(maxSum.maxSum(new int[]{2,-8,3,-2,4,-10}));
    }
    public int maxSum(int[] arr) {
        int sum = 0,maxSum = 0;
        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
            if(maxSum< sum) {
                maxSum = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
