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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        //check for null input
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size; i++){
                //check curr node
                TreeNode curr = queue.poll();
                if(i == size-1) result.add(curr.val);
                //check children
                if(curr.left!= null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return result;
    }
}