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
    int depth;
    public int maxDepth(TreeNode root) {
        return DFS(root);
    }

    private int DFS(TreeNode root){
        if(root == null) return 0;

        // int left = 1 + DFS(root.left);
        // int right = 1 + DFS(root.right);

        int left = DFS(root.left);
        int right = DFS(root.right);

        return 1 + Math.max(left, right);
    }
}

/**
DFS(1,0)

DFS(2,1)

DFS(3,1)
DFS(3,2)
*/

