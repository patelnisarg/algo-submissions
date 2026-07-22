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
    private boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        DFS(root);

        return balance;
    }

    // returns the height of the TreeNode
    private int DFS(TreeNode root){
        if(root == null || balance == false) return 0;

        int left = DFS(root.left); // 1
        int right = DFS(root.right);

        if(Math.abs(left - right) > 1){
            balance = false;
        }

        return 1 + Math.max(left, right);
    }
}
