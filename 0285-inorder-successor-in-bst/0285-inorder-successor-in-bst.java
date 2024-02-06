/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm:

We start our traversal with the root node and continue the traversal until our current node reaches a null value i.e. there are no more nodes left to process.
At each step we compare the value of node p with that of node.
If p.val >= node.val that implies we can safely discard the left subtree since all the nodes there including the current node have values less than p.
However, if p.val < node.val, that implies that the successor must lie in the left subtree and that the current node is a potential candidate for inorder successor. Thus, we update our local variable for keeping track of the successor, successor, to node.
Return successor
*/
class Solution {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor = null;
        while (root != null){
            if(root.val <= p.val) {
                root = root.right;
            }else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}

/*simple solution
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
}*/