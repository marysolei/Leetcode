class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        if nums is None: return -1
        totalSum =sum(nums);
        currSum =0
        for i,num in enumerate(nums):
            if currSum == totalSum-currSum-num: return i
            currSum += nums[i]
        return -1
# time compelxity:O(n)
#space complexity:O(1)