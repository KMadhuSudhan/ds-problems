package ds.problems.trees;
//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
//1315. Sum of Nodes with Even-Valued Grandparent

public class _1315SumOfNodeswithEvenValuedGrandparent {
    int totalSum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root,null,null);
    }

    public int sumEvenGrandparent(TreeNode root,TreeNode parent,TreeNode grandParent)   {
        if(root == null) return 0;
        if(grandParent!=null && grandParent.val%2 == 0) totalSum+=root.val;
        grandParent = parent;
        parent = root;
        sumEvenGrandparent(root.left,parent,grandParent);
        sumEvenGrandparent(root.right,parent,grandParent);
        return totalSum;
    }
}
