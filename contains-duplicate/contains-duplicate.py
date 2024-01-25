class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        #check for null input
        if nums is None: return False
        numSet = set()
        for num in nums:
            if num in numSet: return True
            numSet.add(num)
        return False
    #time and space complexity:O(n)