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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        DFS(root);

        return diameter;
    }

    private int DFS(TreeNode node){
        if(node == null) return 0;

        int left = DFS(node.left);
        int right = DFS(node.right);

        // diameter is the sum of the left and right child nodes
        diameter = Math.max(diameter, left+right);

        return 1 + Math.max(left, right);
    }
}
