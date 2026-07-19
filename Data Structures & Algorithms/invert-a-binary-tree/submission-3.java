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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.removeFirst();
            reverse(node);
            if(node.left != null) stack.addFirst(node.left);
            if(node.right != null) stack.addFirst(node.right);
        }

        return root;
    }

    private void reverse(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return;
    }
}
