package ds.problems.matrix;
//https://leetcode.com/problems/flipping-an-image/
//832. Flipping an Image

public class _832FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            flip(A,i);
            invert(A,i);
        }
        return A;
    }

    void flip(int[][] A,int i) {
        int[] row = A[i];
        int low = 0,high = A[i].length-1;
        while(low<high) {
            int tmp = row[low];
            row[low] = row[high];
            row[high] = tmp;
            low++;
            high--;
        }
        A[i] = row;
    }

    void invert(int[][] A,int i) {
        int[] row = A[i];
        int low = 0,high = A[i].length-1;
        while(low<=high) {
            if(row[low] == 0) {
                row[low] = 1;
            } else {
                row[low] = 0;
            }
            low++;
        }
        A[i] = row;
    }
}
