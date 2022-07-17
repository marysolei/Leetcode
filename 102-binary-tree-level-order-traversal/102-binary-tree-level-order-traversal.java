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
        if(root == null)return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            result.add(new ArrayList<>());
            
            for(int i=0;i<size; i++){
                TreeNode node = queue.poll();
                //add curr node
                result.get(result.size()-1).add(node.val);
                //check children
                if(node.left != null)queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return result;
    }
}
//Time complexity and space complexity of O(n) where n is the number of nodes