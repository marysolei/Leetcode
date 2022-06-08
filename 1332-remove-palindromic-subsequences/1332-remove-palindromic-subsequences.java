class Solution {
    public int removePalindromeSub(String s) {
        
        if(s == null || s.length() ==0)return 0;
        StringBuilder res = new StringBuilder(s);
        String reversed = res.reverse().toString();
        if(reversed.equals(s)) return 1;
        return 2;
    }
}

//Time and Space complexity: O(n)