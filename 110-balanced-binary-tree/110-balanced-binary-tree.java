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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return (isBalanced(root.left) &&
                isBalanced(root.right) &&
                Math.abs(rightHeight-leftHeight)<=1);
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }
}