# https://leetcode.com/problems/range-sum-of-bst/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        def dfs(node) -> int:
            if node:
                if low <= node.val <= high:
                    self.s += node.val
                if low < node.val:
                    dfs(node.left)
                if node.val < high:
                    dfs(node.right)
        self.s = 0
        dfs(root)
        return self.s
