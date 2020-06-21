package ds.problems.test;

public class BuildPrimeMatrix {
    public static void main(String[] args) {
        BuildPrimeMatrix buildPrimeMatrix = new BuildPrimeMatrix();
       int[][] ans =  buildPrimeMatrix.build(5);
        buildPrimeMatrix.print(ans);
    }

    int[][] build(int size) {
        int[][] ans = new int[size][size];
        int r= 0,c=0,num=1,count = 0;

        while(count< size*size) {
            if(isPrime(num)) {
                if(c>= size) {
                    c = 0;
                    r++;
                }
                ans[r][c] = num;
                c++;
                count++;
            }
            num++;
        }
        return ans;
    }

    boolean isPrime(int n) {
        if(n<2) return true;
        for(int i = 2;i*i<= n;i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    void print(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
