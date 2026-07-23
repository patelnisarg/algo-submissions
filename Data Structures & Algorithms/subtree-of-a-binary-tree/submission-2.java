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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return DFS(root, subRoot);
    }

    private boolean DFS(TreeNode p, TreeNode q){
        if(p == null) return false;
        return compare(p, q) || DFS(p.left, q) || DFS(p.right, q);
    }

    private boolean compare(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val){
            return false;
        }

        return compare(p.left, q.left) && compare(p.right, q.right);
    }
}
