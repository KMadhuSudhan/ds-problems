package ds.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    List<List<String>> ans;
    public List<List<String>> printTree(TreeNode root) {
        ans = new ArrayList();
        int height = height(root);
        int rowNodes = (int) Math.pow(height,2) -1;
        fillEmptyString(ans,height,rowNodes);
        dfs(root,rowNodes/2,0);
        return ans;
    }

    void dfs(TreeNode root,int rootIndex,int level) {
        if(root == null) return;
        ans.get(level).set(rootIndex,String.valueOf(root.val));
        dfs(root.left,rootIndex/2,level+1);
        dfs(root.right,rootIndex/2,level+1);
    }


    void fillEmptyString(List<List<String>> list,int height,int nodes){
        for(int i=0;i<height;i++) {
            List<String> row = new ArrayList();
            for(int j=0;j<nodes;j++) {
                row.add("");
            }
            list.add(row);
        }
    }

    int height(TreeNode root) {
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) + 1;
    }

}
