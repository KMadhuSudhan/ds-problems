package ds.problems.trees;
//https://leetcode.com/problems/smallest-string-starting-from-leaf/
//988. Smallest String Starting From Leaf

public class _988SmallestStringStartingFromLeaf {

    String res = null;
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        dfs(root,new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root,StringBuilder sb) {
        if(root == null) return;
        sb.insert(0, (char)('a' + root.val));
        if (root.left == null && root.right == null) {
            String cur = sb.toString();
            if (res == null || res.compareTo(cur) > 0) res = cur;
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(0);
    }

}
