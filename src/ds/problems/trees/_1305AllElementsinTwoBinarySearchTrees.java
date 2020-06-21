package ds.problems.trees;
//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
//1305. All Elements in Two Binary Search Trees

import java.util.ArrayList;
import java.util.List;

public class _1305AllElementsinTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        inorder(root1,list1);
        inorder(root2,list2);
        List<Integer> ans = new ArrayList();
        int i=0,j=0;
        while(i<list1.size() && j<list2.size()) {
            if(list1.get(i)<=list2.get(j)) {
                ans.add(list1.get(i++));
            } else {
                ans.add(list2.get(j++));
            }
        }
        while(i<list1.size()) {
            ans.add(list1.get(i++));
        }
        while(j<list2.size()) {
            ans.add(list2.get(j++));
        }
        return ans;
    }

    void inorder(TreeNode root,List<Integer> list) {
        if(root == null) return ;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
