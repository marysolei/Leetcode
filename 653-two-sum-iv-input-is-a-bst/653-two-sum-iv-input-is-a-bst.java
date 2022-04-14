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
    public boolean findTarget(TreeNode root, int k) {
        
        //using a set 
        HashSet<Integer> set = new HashSet<>();
        if(root == null)return false;
        return helper(root,k, set);
    }
    public boolean helper(TreeNode root, int k , HashSet<Integer> set) {
        
        if(root == null)return false;
        //base case
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        //call fun for children
        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}

//Time and Space complexity of O(n) where n is the number of nodes 