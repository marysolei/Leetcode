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
    public TreeNode searchBST(TreeNode root, int val) {
        
        //check for null input 
        if(root== null)return root;
        //base case
        if(root.val == val)return root;
        //call func for children
        if(root.val > val) return searchBST(root.left, val);
        if(root.val < val) return searchBST(root.right, val);
        return null;
    }
}

//Time complexity: O(logn)in avg case and O(n) in worst case
//Space complexity: O(logn) in avg case to keep the recursion stack and O(n) in worst case