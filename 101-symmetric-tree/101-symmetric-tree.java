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
    public boolean isSymmetric(TreeNode root) {
        
        //check for null input 
        if(root == null)return false;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        //base case
        if(left == null || right == null)return left == right;
        if(left.val != right.val) return false;
        //call func for children
        return helper(left.left,right.right ) && helper(left.right, right.left);
    }
}
//Time and Space complexity of O(n)