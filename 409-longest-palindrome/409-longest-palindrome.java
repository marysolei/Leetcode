class Solution {
    public int longestPalindrome(String s) {
        
        if(s == null || s.length() == 0)return 0;
        int[] count = new int[128];
        for(char c : s.toCharArray()){
            count[c]++;
        }
        int res =0;
        for(int num : count){
            res += (num/2)*2;
            if(res %2 ==0 && num%2==1)res++;
        }
        return res;
    }
}
//time complexity: O(n) where n is the length of s
//space complexity: O(1)