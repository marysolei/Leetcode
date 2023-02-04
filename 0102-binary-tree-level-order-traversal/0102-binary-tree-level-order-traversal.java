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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currList = new ArrayList<>();
            for(int i=0; i< size; i++){
                TreeNode curr = queue.poll();
                currList.add(curr.val);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            result.add(currList);
        }
        return result;
    }
}

//Time and space complexity O(n) where n is the number of nodes