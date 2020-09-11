package ds.problems.array;

public class _135Candy {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        arr[0] = 1;
        for(int i=1;i<ratings.length;i++){
            // minimum number of candies based on left child
            arr[i] = ratings[i]>ratings[i-1]?arr[i-1]+1:1;
        }
        int ans=arr[arr.length-1];
        for (int i = arr.length-2; i >=0; i--) {
            //minimum number of candies based on right child
            arr[i]=ratings[i]>ratings[i+1]?Math.max(arr[i], arr[i+1]+1):arr[i];
            ans+=arr[i];
        }
        return ans;
    }
}
