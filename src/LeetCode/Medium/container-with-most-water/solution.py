# https://leetcode.com/problems/container-with-most-water/
class Solution:

    # brute-force
    # def maxArea(self, height: List[int]) -> int:
    #     area = 0
    #     for i in range(len(height)):
    #         for j in range(i, len(height)):
    #             area = max(area, min(height[i], height[j]) * (j - i))
    #     return area

    # two-pointer optimization
    def maxArea(self, height: List[int]) -> int:
        area = 0
        left = 0
        right = len(height) - 1
        while left < right:
            area = max(area, min(height[left], height[right]) * (right - left))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return area
