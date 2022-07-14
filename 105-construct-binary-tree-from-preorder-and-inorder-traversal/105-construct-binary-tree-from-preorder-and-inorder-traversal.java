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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         
        if (preorder == null || inorder == null || preorder.length != inorder.length )return null;
        return helper(preorder, inorder, 0, 0 ,  inorder.length-1);
    }
    
    public TreeNode helper( int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
         
        if (preStart > preorder.length || inStart > inEnd )return null;
        
        TreeNode res = new TreeNode(preorder[preStart]) ;
        
        int index =0;
        for (int i=inStart; i<=inEnd; i++ ) {
            if (inorder[i] == res.val) {
                index =i;
            }
        }
        res.left = helper(preorder, inorder, preStart+1, inStart, index-1);
        res.right = helper(preorder, inorder, preStart+index-inStart+1, index+1, inEnd);
        
        return res;
    }
}