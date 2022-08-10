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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        //check null input
        if(nums == null || nums.length ==0)return null;
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int left, int right){
        
        if(left> right) return null;
        //chose the middle num as the root
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        //check children
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid+1, right);
        return root;
    }
}

//Time complexity : O(n) we visit each node once
//space complexity: O(logn) the tree is height balanced