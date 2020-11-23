# https://leetcode.com/problems/range-sum-query-immutable/
class NumArray:

    def calc(self):
        if not self.nums:
            return
        self.S = [0] * len(self.nums)
        self.S[0] = self.nums[0]
        for i in range(1, len(self.nums)):
            self.S[i] = self.S[i - 1] + self.nums[i]

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.S = []
        self.calc()

    def sumRange(self, i: int, j: int) -> int:
        if not self.S:
            return 0
        if i == 0:
            return self.S[j]
        return self.S[j] - self.S[i - 1]
