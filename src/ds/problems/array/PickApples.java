package ds.problems.array;
//https://www.lintcode.com/problem/pick-apples/description
//1850. Pick Apples

public class PickApples {
    public static void main(String[] args) {
        PickApples pickApples = new PickApples();
        int[] a = new int[]{6, 1, 4, 6, 3, 2, 7, 4};
        pickApples.PickApples(a,3,2);
    }
    public int PickApples(int[] A, int K, int L) {
      int total = K + L;
      if(total > A.length) return -1;
      int sum = 0;

      if(total == A.length) {
          for(int i=0;i<A.length;i++) {
              sum += A[i];
          }
          return sum;
      } else {
          int max = Math.max(L,K);
          int min = Math.min(L,K);
          int maxKSum=0,maxLSum=0,left = 0,l =0;
          for(int i=0;i<max;i++) {
              sum+= A[i];
          }
          maxKSum = sum;
          for (int i=max;i<A.length;i++) {
              int newSum = sum + A[i] - A[l++];
              if(newSum > sum) {
                  left = i;
                  maxKSum = newSum;
              }
          }
          int right = left + max;
          sum = 0;
          if(left >= min && min <= right) {
              l = right+1;
              for(int i=right+1;i<right+min+1;i++) {
                  sum+= A[i];
              }
              maxLSum = sum;
              for(int i=right+min;i<A.length;i++) {
                  int newSum = sum + A[i] - A[l++];
                  if(newSum > sum) {
                      maxLSum = newSum;
                  }
              }
          } else {
              l = 0;
              for(int i=0;i<min;i++) {
                  sum+= A[i];
              }
              maxLSum = sum;
              for(int i=min;i<A.length;i++) {
                  if(i >= min && i <= right) {
                      i =right+1;
                      sum = 0;
                      int j =0;
                      l = right;
                      while (i<A.length && j<min) {
                          sum+= A[i];
                          i++;
                          j++;
                      }
                      if(j==min && i == A.length) {
                          maxLSum = Math.max(sum,maxLSum);
                      }
                      i-=2;
                  } else {
                      int newSum = sum + A[i] - A[l++];
                      if (newSum > sum) {
                          maxLSum = newSum;
                      }
                  }
              }
          }
          return maxKSum + maxLSum;
      }
    }
}
