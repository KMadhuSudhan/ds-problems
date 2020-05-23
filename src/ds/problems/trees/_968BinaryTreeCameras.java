package ds.problems.trees;
//https://leetcode.com/problems/binary-tree-cameras/
//968. Binary Tree Cameras

public class _968BinaryTreeCameras {
    int ans = 0;
    int NULL = 0;
    int COVER = 1;
    int CAMERA = 2;

    public static void main(String[] args) {
        _968BinaryTreeCameras binaryTreeCameras = new _968BinaryTreeCameras();

    }
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        ans = 0;
        if(dfs(root) == NULL) ans++;
        return ans;
    }

    public int dfs(TreeNode root) {
        if(root == null) return COVER;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == NULL || right == NULL) {
            ans++;
            return CAMERA;
        }
        if(left == CAMERA || right == CAMERA) {
            return COVER;
        }
        return NULL;
    }
}
