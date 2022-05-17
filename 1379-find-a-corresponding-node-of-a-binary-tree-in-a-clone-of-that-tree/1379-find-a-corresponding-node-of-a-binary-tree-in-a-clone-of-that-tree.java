/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //check for null input
        if(original == null)return null;
        
        //Queue for bfs traversal of original and cloned tree
        Queue<TreeNode> originalQ = new ArrayDeque<>();
        Queue<TreeNode> clonedQ = new ArrayDeque<>();
        //add roots to the queues
        originalQ.add(original);
        clonedQ.add(cloned);
        
        //bfs traversal
        while(!originalQ.isEmpty()){
            TreeNode originalNode = originalQ.poll();
            TreeNode clonedNode = clonedQ.poll();
            //if we find the target
            if(originalNode == target) return clonedNode;
            
            //add left and right children to the queue for bfs traversal
            if(originalNode.left != null) {
                originalQ.add(originalNode.left);
                clonedQ.add(clonedNode.left);
            }
            if(originalNode.right != null){
                originalQ.add(originalNode.right);
                clonedQ.add(clonedNode.right);
            }
        }
        return null;
    }
}

//Time and space complexity of O(n) sine we need to visit each node and we store the nodes in a queue of size of n.