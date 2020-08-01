package ds.problems.math;
//https://leetcode.com/problems/reordered-power-of-2/
//869. Reordered Power of 2

public class _869ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        int[] a = new int[10];
        while(N>0)
        {
            a[N%10]++;
            N=N/10;
        }
        for(int i=0;i<31;i++)
        {
            int temp=1<<i;
            System.out.println(temp);
            int[] b = new int[10];
            while(temp>0)
            {
                b[temp%10]++;
                temp=temp/10;
            }
            int j;
            for(j=0;j<10;j++)
            {
                if(a[j]!=b[j])break;
            }
            if(j==10)return true;
        }
        return false;
    }
}
