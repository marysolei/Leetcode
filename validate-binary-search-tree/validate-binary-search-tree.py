# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def helper(root, min=-math.inf, max=math.inf):
            if not root : return True
            if root.val <= min or root.val >= max: return False
            return helper(root.left, min, root.val)and helper(root.right, root.val, max)
        return helper(root)
    
    #time and space complexity:O(n)