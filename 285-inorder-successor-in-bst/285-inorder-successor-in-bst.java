/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        //check for null input 
        if(root == null)return null;
        TreeNode successor = null;
        
        while(root != null){
            if(root.val <= p.val){
                root = root.right;
            }else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
//Time complexity: O(n)
//space complexity: O(1)