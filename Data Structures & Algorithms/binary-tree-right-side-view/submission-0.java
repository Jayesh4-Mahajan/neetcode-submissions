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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode n = p.getKey();
            Integer height = p.getValue();
            if (res.size() == height) {
                res.add(0);
            }
            res.set(height, n.val);
            if (n.right != null) stack.add(new Pair(n.right, height+1));
            if (n.left != null) stack.add(new Pair(n.left, height+1));
        }
        return res;
    }
}
