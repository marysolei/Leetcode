class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        #check for null input 
        if nums is None: return -1
        currMax = 0
        indexMax = -1
        for i, num in enumerate(nums): 
            if num> currMax:
                currMax = num
                indexMax = i 
        for num in nums:
            if num != currMax:
                if num*2 > currMax: return -1
        return indexMax