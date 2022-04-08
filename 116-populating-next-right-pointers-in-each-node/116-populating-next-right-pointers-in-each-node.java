/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        //check for null input
        if(root == null)return root;
        //queue of nodes for level order traversal
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size; i++) {
                Node curr = queue.poll();
                if(i<size-1) curr.next = queue.peek();
                if(curr.left!= null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        return root;
    }
}

//Time Complexity: O(N) we need to visit each note exactly once
//Space Complexity: O(N) the space for bfs traversal