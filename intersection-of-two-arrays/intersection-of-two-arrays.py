class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        for num in nums1:
            if(num not in res and num in nums2):
                res.append(num)
        return res