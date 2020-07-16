package ds.problems.array;
//https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
//1491. Average Salary Excluding the Minimum and Maximum Salary

public class _191AverageSalary {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<salary.length;i++){
            sum+=salary[i];
            min = Math.min(min,salary[i]);
            max = Math.max(max,salary[i]);
        }
        sum = sum - (min + max);
        int length = salary.length -2;
        return (double)sum/(double)length;
    }
}
