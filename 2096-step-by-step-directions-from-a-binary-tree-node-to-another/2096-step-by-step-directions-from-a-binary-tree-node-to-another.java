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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        //check for null input 
        if(root == null || startValue == destValue)return "";
        
        StringBuilder sPath = new StringBuilder();
        StringBuilder dPath = new StringBuilder();
        getPath(root, startValue, sPath);
        getPath(root, destValue, dPath);
        
        int sLen = sPath.length();
        int dLen = dPath.length();
        int index = 0;
        while (index < Math.min(sLen,dLen) && sPath.charAt(sLen - index - 1) == dPath.charAt(dLen - index - 1))
            ++index;
        return "U".repeat(sLen - index) + dPath.reverse().toString().substring(index);
    }
    
    public boolean getPath(TreeNode root, int nodeValue, StringBuilder sb){
        
        if(nodeValue == root.val) return true;
        if(root.left != null && getPath(root.left, nodeValue, sb)) sb.append("L");
        else if(root.right != null && getPath(root.right, nodeValue, sb)) sb.append("R");
        return sb.length()>0;
    }
}
/*The shortest path between any two nodes in a tree must pass through their Lowest Common Ancestor (LCA). The path will travel upwards from node s to the LCA and then downwards from the LCA to node t.
Find the path strings from root → s, and root → t. Can you use these two strings to prepare the final answer?
Remove the longest common prefix of the two path strings to get the path LCA → s, and LCA → t. Each step in the path of LCA → s should be reversed as 'U'.*/