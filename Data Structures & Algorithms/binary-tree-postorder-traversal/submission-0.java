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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null) return output;

        DFS(root, output);

        return output;
    }

    private void DFS(TreeNode root, List<Integer> output){
        if(root == null) return;

        DFS(root.left, output);
        DFS(root.right, output);
        output.add(root.val);

        return;
    }
}