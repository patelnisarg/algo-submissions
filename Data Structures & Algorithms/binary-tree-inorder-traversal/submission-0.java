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
// inorder-> left -> root -> right
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null) return output;

        DFS(root, output);

        return output;
    }

    private void DFS(TreeNode root, List<Integer> values){
        if(root == null) return;

        DFS(root.left, values);
        values.add(root.val);
        DFS(root.right, values);
    }
}