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
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        //check for null input 
        if(root == null) return result;
        height(root, result);
        return result;
    }
    public int height(TreeNode root, List<List<Integer>> result){
        
        if(root == null) return -1;
        int left = height(root.left, result);
        int right = height(root.right,result);
        int level = 1+ Math.max(left,right);
        if(result.size() == level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        root.left = root.right = null;
        return level;
    }
}
/* The key is to find the height of each node.The height of a node is the number of 
edges from the node to the deepest leaf. the height of leaf is 0. The essential of 
problem is not to find the leaves, but group leaves of same level together and also to 
cut the tree. This is the exact role backtracking plays. The helper function returns 
the level which is the distance from its furthest subtree leaf to root, which helps to 
identify which group the root belongs to. 
The height of a node is also its index in the result list (res). For example, leaves, 
whose heights are 0, are stored in res[0]. Once we find the height of a node, we can 
put it directly into the result.*/