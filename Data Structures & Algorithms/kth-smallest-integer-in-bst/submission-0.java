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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();

        inOrder(root, res);
        return res.get(Integer.valueOf(k-1));
    }

    public void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (node.left != null) {
            inOrder(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            inOrder(node.right, res);
        }
    }
}
