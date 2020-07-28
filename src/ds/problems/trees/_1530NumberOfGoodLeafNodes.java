package ds.problems.trees;
//https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
//1530. Number of Good Leaf Nodes Pairs

public class _1530NumberOfGoodLeafNodes {

    int res=0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return res;
    }
    public int[] dfs(TreeNode root, int distance){
        if(root == null) return new int[0];
        if(root.left == null && root.right == null) {
            return new int[]{1};
        }

        int[] left = dfs(root.left,distance);
        int[] right = dfs(root.right,distance);
        for (int l: left)
            for (int r: right)
                if (l+r<=distance) res++;
        int[] cur = new int[left.length+right.length];
        int idx = 0;
        for(int l: left) cur[idx++] = l+1;
        for(int r: right) cur[idx++] = r+1;
        return cur;
    }

}
