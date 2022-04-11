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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;
        helper(root, result);
        return result;
    }
    public void helper(TreeNode root, List<Integer> result){
        //base case 
        if (root == null)return;
        //call helper func for children
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n). The worst case space required is O(n), and in the average case it's O(logn) where n is number of nodes.