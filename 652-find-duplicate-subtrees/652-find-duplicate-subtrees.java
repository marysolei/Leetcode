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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
     
        if(root == null)return null;
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, List<TreeNode>> hmap = new HashMap<>();
        traverse(root, hmap);
        for(String key: hmap.keySet()){
            List<TreeNode> curr = hmap.get(key);
            if(curr.size()>1)res.add(curr.get(0));
        }
        return res;
    }
    public String traverse (TreeNode root, HashMap<String, List<TreeNode>> hmap){
        if(root == null)return "";
        String s = "(" + traverse(root.left, hmap)+ root.val + traverse(root.right, hmap)+")";
        if(!hmap.containsKey(s)) hmap.put(s, new ArrayList<>());
        hmap.get(s).add(root);
        return s;
    }
}
/*- A unique sub-tree can be uniquely identified by its serialized string
- using post order traversal we can gradualy collect all unique tree-serializations with their associated nodes, with 1 traversal
- then you can see if there is any serialization is associated with more than 1 sub-tree nodes, then you know there is duplicated sub-tree nodes
*/