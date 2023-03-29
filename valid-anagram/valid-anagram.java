class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s == null || t == null) return s==t;
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c: t.toCharArray()){
            arr[c-'a']--;
            if(arr[c-'a']<0) return false;
        }
        return true;
    }
}
//time complexity: O(n)
//space complexity: O(1) we use extra space but the table size is constant