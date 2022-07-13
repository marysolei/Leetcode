class Solution {
    public boolean isSubsequence(String s, String t) {
        
        //check for edge cases 
        if(s == null || t== null)return false;
        if(s.length() > t.length()) return false;
        int sPtr = 0;
        int tPtr = 0;
        while(sPtr< s.length() && tPtr <t.length()){
            if(s.charAt(sPtr) == t.charAt(tPtr)){
                sPtr++;
                tPtr++;
            }else tPtr++;
        }
        return sPtr == s.length();
    }
}