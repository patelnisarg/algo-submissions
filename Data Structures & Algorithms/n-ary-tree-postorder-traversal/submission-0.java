/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> output = new ArrayList<>();
        if(root == null) return output;

        DFS(root, output);

        return output;
    }

    private void DFS(Node root, List<Integer> output){
        if(root == null) return;

        for(Node child : root.children){
            DFS(child, output);
        }
        output.add(root.val);

        return;
    }
}