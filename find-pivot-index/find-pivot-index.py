class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        if nums is None: return
        totalSum = sum(nums)
        currSum = 0
        for index, num in enumerate(nums):
            if totalSum - currSum - num == currSum: return index
            currSum += num
        return -1
    #time complexity:O(n)
    #space complexity:O(1)