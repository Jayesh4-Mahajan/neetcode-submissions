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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = findIndex(inorder, preorder[0]);

        int[] pre = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] in = Arrays.copyOfRange(inorder, 0, mid); 
        root.left = buildTree(pre, in);
        pre = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        in = Arrays.copyOfRange(inorder, mid + 1, preorder.length); 
        root.right = buildTree(pre, in);

        return root;
    }

    public static int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index when the value is found
            }
        }
        return -1; // Return -1 if the value is not found in the array
    }
}
