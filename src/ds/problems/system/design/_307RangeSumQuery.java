package ds.problems.system.design;
//https://leetcode.com/problems/range-sum-query-mutable/
//307. Range Sum Query - Mutable

public class _307RangeSumQuery {
    int[] st;
    int[] nums;
    public _307RangeSumQuery(int[] nums) {
        if(nums.length!=0) {
            int length = nums.length;
            int x = (int) (Math.ceil(Math.log(length)/Math.log(2)));
            int size = 2 * (int) Math.pow(2,x) -1;
            this.st = new int[size];
            this.nums = nums;
            buildSt(0,0,length-1);
        }
    }

    void buildSt(int index,int left,int right) {
        if(left == right) {
            st[index] = nums[left];
            return;
        }
        int mid = left + (right-left)/2;
        buildSt(2*index+1,left,mid);
        buildSt(2*index+2,mid+1,right);
        st[index] = st[index*2+1] + st[index*2+2];
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        updateUtil(0,0,nums.length-1,i,diff);
    }
    public void updateUtil(int index,int left,int right,int i,int diff) {
        if(i < left || i > right) return;
        st[index]+=diff;
        if(left>=right) return;
        int mid = left + (right - left)/2;
        updateUtil(index*2+1,left,mid,i,diff);
        updateUtil(index*2+2,mid+1,right,i,diff);
    }

    public int sumRange(int i, int j) {
        return query(0,0,nums.length-1,i,j);
    }
    int query(int index,int left,int right,int i,int j) {
        if(left>=i && right<= j) return st[index];
        if(right < i || left > j) return 0;
        int mid = left + (right-left)/2;
        int leftSum = query(2*index+1,left,mid,i,j);
        int rightSum = query(2*index+2,mid+1,right,i,j);
        return leftSum  + rightSum;
    }
}
