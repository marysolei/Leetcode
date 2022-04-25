/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        //we don't have root of the tree so we need to get the root
        Node root = p;
        while(root.parent != null) {
            root = root.parent;
        }
        return lcaHelper(root, p, q);
    }
    public Node lcaHelper(Node root, Node p, Node q){
        
        //check for basic case 
       if(root == null)return null;
        if(root == p || root ==q)return root;
        //call func for children
        Node left = lcaHelper(root.left, p, q);
        Node right = lcaHelper(root.right, p, q);
        
        if(left != null && right != null) return root;
        if(left == null && right == null) return null;
        return left == null? right: left;
    }
}

//Time compelxity of O(n) worst case scenario we need to check all the nodes in the tree