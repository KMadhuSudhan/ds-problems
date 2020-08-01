package ds.problems.trees;
//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
//331. Verify Preorder Serialization of a Binary Tree

public class _331VerifyPreorderSerializationBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int l = 1;

        for (int i = 0; i < nodes.length; i++) {
            if (l == 0)  return false;
            l = nodes[i].equals("#") ? --l : ++l;
        }

        return l == 0;
    }
}
