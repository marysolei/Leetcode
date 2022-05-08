class Solution {
    public int countBinarySubstrings(String s) {
        
        int[] groups = new int[s.length()];
        int index = 0;
        groups[0] = 1;
        for(int i=1; i< s.length(); i++){
            if(s.charAt(i-1) != s.charAt(i)){
                groups[++index] = 1;
            }else {
                groups[index]++;
            }
        }
        int res = 0;
        for(int i=1; i<=index; i++) {
            res += Math.min(groups[i-1], groups[i]);
        }
        return res;
    }
}
//Time and Space complexity: O(n)

/*From Leetcode: We can convert the string s into an array groups that 
represents the length of same-character contiguous blocks within the 
string. For example, if s = "110001111000000", then groups = [2, 3, 4, 6].
Let's try to count the number of valid binary strings between groups[i] and groups[i+1]. If we have groups[i] = 2, groups[i+1] = 3, then it represents either "00111" or "11000".
We clearly can make min(groups[i], groups[i+1]) valid binary strings within this string. Because the binary digits to the left or right of this string must change at the boundary, our answer can never be larger.

Algorithm
Let's create groups as defined above. The first element of s belongs in it's own group. 
From then on, each element either doesn't match the previous element, so that it starts a new group of size 1; 
or it does match, so that the size of the most recent group increases by 1.
Afterwards, we will take the sum of min(groups[i-1], groups[i]).*/