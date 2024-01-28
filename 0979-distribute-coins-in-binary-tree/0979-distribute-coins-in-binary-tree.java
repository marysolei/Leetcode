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
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfsHelper(root);
        return res;
    }
    public int dfsHelper(TreeNode root){
        if (root == null) return 0;
        int left = dfsHelper(root.left);
        int right = dfsHelper(root.right);
        res += Math.abs(left)+Math.abs(right);
        return root.val+ left+right-1;
    }
}

/*If the leaf of a tree has 0 coins (an excess of -1 from what it needs), then we should push a coin from its parent onto the leaf. If it has say, 4 coins (an excess of 3), then we should push 3 coins off the leaf. In total, the number of moves from that leaf to or from its parent is excess = Math.abs(num_coins - 1). Afterwards, we never have to consider this leaf again in the rest of our calculation. Let dfs(node) be the excess number of coins in the subtree at or below this node: namely, the number of coins in the subtree, minus the number of nodes in the subtree. Then, the number of moves we make from this node to and from its children is abs(dfs(node.left)) + abs(dfs(node.right)). After, we have an excess of node.val + dfs(node.left) + dfs(node.right) - 1 coins at this node.*/