class Solution:
    def firstUniqChar(self, s: str) -> int:
        #check for null input
        if not s: return -1
        hmap = {}
        for c in s: 
            if c not in hmap: hmap[c]=1
            else: hmap[c]+=1
        for i in range(len(s)):
            if hmap[s[i]] ==1: return i
        return -1
#time and space compelxity: O(n)