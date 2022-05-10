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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        //check for null input 
        if(root == null)return result;
        if(!isLeaf(root)) result.add(root.val);
        
        //left side
        TreeNode curr = root.left;
        while (curr != null) {
            if(!isLeaf(curr)) result.add(curr.val);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
        //add leaves 
        addLeaves(result, root);
        //right side -> use a stack to reverse the order of the right side from bottom to top
        Stack<Integer> stack = new Stack<>();
        curr = root.right;
        while(curr != null){
            if(!isLeaf(curr)) stack.push(curr.val);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        while(!stack.isEmpty()) result.add(stack.pop());
        return result;
    }
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    public void addLeaves(List<Integer> result, TreeNode root){
        if(isLeaf(root)){
            result.add(root.val);
        }else {
            if(root.left != null) addLeaves(result, root.left);
            if(root.right != null)addLeaves(result, root.right);
        }
    } 
}

//Time complexity:O(n) 
//space complexity: O(n) result and stack takes O(n) space