class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if digits is None: return digits
        n = len(digits)
        for i in range(n):
            index = n-i-1;
            if digits[index] == 9:
                digits[index]=0
            else:
                digits[index]+=1
                return digits
        return [1]+digits
    
#time and space complexity:O(n)