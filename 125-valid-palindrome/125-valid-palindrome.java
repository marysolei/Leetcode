class Solution {
    public boolean isPalindrome(String s) {
        
        if(s == null || s.length()==0)return true;
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        s = s.replaceAll(" ","");
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right))  return false;
            left++;
            right--;
        }
        return true;
    }
}
//Time compelxity: O(n) where n is the length of the string
//space compelxity: O(1)