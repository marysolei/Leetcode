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
    public boolean isValidBST(TreeNode root) {
        //check for null input 
        if(root == null) return true;
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null)return true;
        if((min != null && root.val <= min) || (max != null &&root.val>= max))return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
//Time complexity:O(n)
//space complexity:O(n)