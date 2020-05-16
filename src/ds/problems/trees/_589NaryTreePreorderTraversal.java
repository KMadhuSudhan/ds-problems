package ds.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class _589NaryTreePreorderTraversal {
    List<Integer> ans = new ArrayList();
    public List<Integer> preorder(Node root) {
        if(root == null) return ans;
        ans.add(root.val);
        for(Node node: root.children) {
            preorder(node);
        }
        return ans;
    }
}
