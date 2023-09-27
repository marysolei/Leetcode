class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        #check for null input 
        if not jewels or not stones: return 0
        jewelSet = set()
        res = 0
        for j in jewels: jewelSet.add(j)
        for s in stones: 
            if s in jewelSet: res+=1
        return res