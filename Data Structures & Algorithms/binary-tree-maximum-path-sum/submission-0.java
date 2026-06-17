/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[]{root.val};
        pathSum(root, res);
        return res[0];
    }

    public int pathSum(TreeNode node, int[] res) {
        if (node == null) return 0;
        int lp = Math.max(pathSum(node.left, res), 0);
        int rp = Math.max(pathSum(node.right, res), 0);
        res[0] = Math.max(res[0], node.val + lp + rp);
        return node.val + Math.max(lp, rp);
    }
}
