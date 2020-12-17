package ds.problems.array;

import ds.problems.trees.TreeNode;

import java.util.TreeMap;

public class _threeSumSmaller {
    class Tree {
        int val;
        Tree left;
        Tree right;
        int j;
        int k;
        Tree(int val,int j,int k) {
            this.val = val;
            this.j = j;
            this.k = k;
        }
    }
    Tree root = null;
    int count = 0;
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                int sum = nums[i] + nums[j];
                root = insert(root,sum,i,j);
            }
        }
        for(int i=0;i<nums.length-2;i++) {
            search(root,nums[i],i,target);
            ans+=count;
            count = 0;
        }
        return ans;
    }
    void search(Tree root, int val,int i,int target) {
        if(root == null) return;
        if(root.val + val < target && i < root.j && i < root.k ) {
            count++;
        }
        if(val + root.val > target) {
            search(root.right,val,i,target);
        } else {
            search(root.left,val,i,target);
        }
    }
    Tree insert(Tree node,int val,int i,int j) {
        if(node == null) {
            node = new Tree(val,i,j);
        } else {
            if(val <= root.val) {
                node.left = insert(node,val,i,j);
            } else {
                node.right = insert(node,val,i,j);
            }
        }
        return node;
    }
}
