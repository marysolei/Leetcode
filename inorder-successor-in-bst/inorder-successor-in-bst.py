# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        successor = None
        while root:
            if root.val <= p.val:
                root = root.right
            else: 
                successor = root;
                root = root.left
        return successor
    
#time compelxity: O(n) in general and O(logn) for a balanced BST
#space complexity:O(1) since we don't use recursion