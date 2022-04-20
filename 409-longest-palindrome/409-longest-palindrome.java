class Solution {
    public int longestPalindrome(String s) {
        
        int[] count = new int[128];
        for(char c : s.toCharArray()){
            count[c]++;
        }
        int res = 0;
        for(int key : count){
            res += key/2*2;
            if(res %2 == 0 && key%2==1) res++;
        }
        return res;
    }
}

//time complexity: O(n) where n is the length of s
//space complexity: O(1)