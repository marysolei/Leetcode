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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        //check for null input 
        if(root == null)return false;
        //base case
        if(root.left == null && root.right == null && root.val == targetSum)return true;
        //call func for children 
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
        
    }
}
//Time Complexity: O(N) we visit each node exactly once
//Space Complexity: O(N) in worst case; O(logN) in the case that the tree is balanced