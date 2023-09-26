class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        #check for null input 
        if(not nums) :
            return False
        hset = set()
        for num in nums:
            if num in hset:
                return True
            hset.add(num)
            
        return False
                
    