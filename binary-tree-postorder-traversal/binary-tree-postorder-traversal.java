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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //check for null input
        if(root == null)return result;
        helper(root, result);
        return result;
    }
    public void helper(TreeNode root, List<Integer> result){
        if(root == null)return;
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }
}
//Time and space complexity: O(n)