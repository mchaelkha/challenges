# https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution:

    def removeDuplicates(self, nums) -> int:
        end = len(nums)
        if end <= 1:
            return
        i = 1
        while i < end:
            if nums[i - 1] == nums[i]:
                end -= 1
                del nums[i]
            else:
                i += 1
        return end
