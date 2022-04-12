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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        //check for null input 
        if(root == null)return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
       
        //bfs through the nodes
        while(!queue.isEmpty()){
            int size = queue.size();
            result.add(new ArrayList<>());
           //check each level
            for(int i=0; i< size; i++){
                TreeNode curr = queue.poll();
                result.get(result.size()-1).add(curr.val);
                //check children 
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null)queue.add(curr.right);
            }
        }
        return result;   
    }
}

//Time complexity and space complexity of O(n) where n is the number of nodes