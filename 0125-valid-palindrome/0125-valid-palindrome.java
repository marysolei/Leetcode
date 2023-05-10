class Solution {
    public boolean isPalindrome(String s) {
        
        if(s == null || s.length() ==0)return false;
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
}