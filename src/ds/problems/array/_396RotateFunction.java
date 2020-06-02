package ds.problems.array;
//https://leetcode.com/problems/rotate-function/
//396. Rotate Function

public class _396RotateFunction {
    public static void main(String[] args) {
        _396RotateFunction rotateFunction = new _396RotateFunction();
        int[] nums = {4,3,2,6};
        System.out.println(rotateFunction.maxRotateFunction(nums));
    }
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int function = 0;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            function += A[i] * i;
        }
        res = function;
        for (int i = 1; i < n; i++) {
            function = function + sum - n * (A[n - i]);
            res = Math.max(res, function);
        }
        return res;
    }
}
