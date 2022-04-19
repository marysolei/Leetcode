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
    TreeNode node1= null, node2 = null, prev = null;
    
    public void recoverTree(TreeNode root) {
        
        findTwoSwappedNodes(root);
        swap(node1, node2);
    }
    public void swap (TreeNode node1, TreeNode node2){
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
    public void findTwoSwappedNodes(TreeNode root){
        //check for null input
        if(root == null)return;
        //inorder traversal
        findTwoSwappedNodes(root.left);//left side
        //curr node 
        if(prev != null && root.val < prev.val){
            node2 = root;
            if(node1== null) node1= prev;
            else return;
        }
        prev = root;
        //right isde 
        findTwoSwappedNodes(root.right);
    }
    
}
/*From Leetcode: 
Algorith: 
- Construct inorder traversal of the tree. It should be an almost sorted list where only two elements are swapped.
- Identify two swapped elements x and y in an almost sorted array in linear time.
- Traverse the tree again. Change value x to y and value y to x.*/

//Time and Space complexity: O(n)