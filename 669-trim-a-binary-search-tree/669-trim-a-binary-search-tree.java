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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        //check for null input 
        if(root == null)return root;
        if(root.val > high) return trimBST(root.left, low, high);
        if(root.val< low) return trimBST(root.right, low, high);
        // otherwise we trim both sides of the tree
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}

/*When node.val > high, we know that the trimmed binary tree must occur to the left of the node. Similarly, when node.val < low, the trimmed binary tree occurs to the right of the node. Otherwise, we will trim both sides of the tree.*/

//Time and Space complexity :O(n) where n is the number of nodes in the tree