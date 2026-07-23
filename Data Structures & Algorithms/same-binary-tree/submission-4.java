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
    private boolean same = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        DFS(p, q);

        return same;
    }

    private boolean DFS(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null  || q == null || p.val != q.val || same == false){
            same = false;
            return false;
        }

        DFS(p.left, q.left);
        DFS(p.right, q.right);

        return true;
    }
}
