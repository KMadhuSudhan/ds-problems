package ds.problems.trees;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//297. Serialize and Deserialize Binary Tree

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _297SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null ";
        String out = root.val + " ";
        out += serialize(root.left);
        out += serialize(root.right);
        return out;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(" "));
        return helper(list.iterator());
    }

    private TreeNode helper(Iterator<String> itr) {
        if(itr == null || !itr.hasNext()) {
            return null;
        }

        String val = itr.next().trim();
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper(itr);
        node.right = helper(itr);
        return node;
    }
}
