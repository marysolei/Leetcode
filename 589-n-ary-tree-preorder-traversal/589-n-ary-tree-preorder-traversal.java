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
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        
        List<Integer> result = new ArrayList<>();
        //check for null input 
        if(root == null)return result;
        helper(root, result);
        return result;
    }
    public void helper(Node root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        for(Node curr: root.children){
            helper(curr, result);
        }
        return;
    }
}
/*public List<Integer> preorder(Node root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            result.add(curr.val);
            for(int i= curr.children.size()-1; i>= 0 ; i--){
                stack.add(curr.children.get(i));
            }
        }
        return result;
    }*/