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
        if(root == null)return result;
        helper(root, result);
        return result;
    }
    public void helper(TreeNode root, List<Integer> result){
        //base case 
        if(root == null)return;
        //call helper func for children
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }
}
//time and space complexity of O(n)