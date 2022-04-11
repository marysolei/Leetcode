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
    public int maxDepth(TreeNode root) {
        //check for null input & base case
        if(root == null)return 0;
        //call the func for children
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}
//Time complexity : we visit each node exactly once, thus the time complexity is O(N)
//Space complexity : in the worst case, the tree is completely unbalanced, the recursion call would occur N times (the height of the tree)O(N). But in the best case (the tree is completely balanced), the height of the tree would be log(N)