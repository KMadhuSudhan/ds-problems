package ds.problems.trees;
//https://leetcode.com/contest/weekly-contest-190/problems/pseudo-palindromic-paths-in-a-binary-tree/
//5418. Pseudo-Palindromic Paths in a Binary Tree
public class _5418PseudoPalindromicPathsinaBinaryTree {

    int count =0;
    public static void main(String[] args) {
        _5418PseudoPalindromicPathsinaBinaryTree pseudoPalindromicPathsinaBinaryTree = new _5418PseudoPalindromicPathsinaBinaryTree();
        StringToTreeNode stringToTreeNode = new StringToTreeNode();
        TreeNode treeNode = stringToTreeNode.stringToTreeNode("[2,3,1,3,1,null,1]");
        System.out.println(pseudoPalindromicPathsinaBinaryTree.pseudoPalindromicPaths(treeNode));
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return 0;
        pseudoPalindromicPaths(root,1,new int[9]);
        return count;
    }

    public void pseudoPalindromicPaths (TreeNode root,int totalCount,int[] numbers) {
        if(root == null) return;
        numbers[root.val-1]++;

        if(root.left == null && root.right == null) {
            int numCount = 0;
            for(int i=0;i<9;i++) {
                if(numbers[i] > 0 && numbers[i]%2 == 0) {
                    numCount++;
                }
            }
            if(numCount>=totalCount/2) count++;
            numbers[root.val-1]--;
            return;
        }
        pseudoPalindromicPaths(root.left,totalCount+1,numbers);
        pseudoPalindromicPaths(root.right,totalCount+1,numbers);
    }
}
