package ds.problems.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _652FindDuplicateSubtrees {

    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        serializeTree(root);
        return res;
    }
    public String serializeTree(TreeNode root) {
        if(root == null) return "#";
        String serial = root.val + "," + serializeTree(root.left) + "," + serializeTree(root.right);
        Integer freq = map.get(serial);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            res.add(root);
        }
        return serial;
    }
}
