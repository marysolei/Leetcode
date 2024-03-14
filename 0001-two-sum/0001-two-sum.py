class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if nums is None: return
        hmap = {}
        for i in range(len(nums)):
            if nums[i] in hmap and hmap[nums[i]]!= i:
                return [hmap[nums[i]],i]
            else:
                hmap[target-nums[i]]=i
        return[]
    
#time and space complexity: O(n)