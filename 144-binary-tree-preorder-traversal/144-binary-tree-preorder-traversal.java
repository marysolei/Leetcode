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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        //check for null input 
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result);
        return result;
    }
    public void helper(TreeNode root, List<Integer> result){
        //base case
        if(root== null)return ;
        //call helper func for children
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }
}
/*Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
Space complexity : depending on the tree structure, we could keep up to the entire tree, therefore, the space complexity is O(N).
*/