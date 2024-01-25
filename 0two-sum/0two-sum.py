class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #check for null input 
        if nums is None: return nums
        hmap = {}
        for i in range(len(nums)):
            if(nums[i] in hmap and hmap[nums[i]] !=i):
                return {hmap[nums[i]],i}
            hmap[target-nums[i]]= i
        return{}
    
#time and space complexity: O(n)