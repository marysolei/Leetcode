class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #check for null input 
        if not nums: return nums
        hmap = {}
        
        for i in range(len(nums)):
            hmap[nums[i]]=i
        for i in range(len(nums)):
            complement = target-nums[i]
            if complement in hmap and i != hmap[complement]:
                return[i, hmap[complement]]
    
#time and space complexity: O(n)