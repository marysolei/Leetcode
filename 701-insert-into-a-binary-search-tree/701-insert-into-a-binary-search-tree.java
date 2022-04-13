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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        //check for null input & base case
        if(root == null)return new TreeNode(val);
        //call fun for children
        if(root.val < val) root.right = insertIntoBST(root.right, val);
        if(root.val > val) root.left = insertIntoBST(root.left, val);
        return root;
    }
}
//Time and Space complexity of O(logn) for avg case and O(n) for worst case