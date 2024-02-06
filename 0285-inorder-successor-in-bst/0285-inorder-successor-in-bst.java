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
        if(root == null || p == null) return null;
        List<TreeNode> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        for(int i=0; i<inorderList.size();i++){
            if(inorderList.get(i) == p){
                if(i+1<inorderList.size()){
                    return inorderList.get(i+1);
                }
            }
        }
        return null;
    }
    public void inorder(TreeNode root, List<TreeNode> list){
        if(root == null)return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right,list);
    }
}