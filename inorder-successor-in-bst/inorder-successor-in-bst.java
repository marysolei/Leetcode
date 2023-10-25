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
        if (root == null)return null;
        List<TreeNode> result = new ArrayList<>();
        helper(root, result);
        for(int i=0; i< result.size(); i++){
            if(result.get(i) ==p) {
                if (i+1< result.size()) {
                    return result.get(i+1);
                }
            }
        }
        return null;
    }
    public void helper(TreeNode root, List<TreeNode> result){
        if(root == null)return;
        helper(root.left, result);
        result.add(root);
        helper(root.right, result);
    }
}