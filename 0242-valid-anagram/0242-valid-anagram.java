class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s == null || t == null)return s==t;
        if(s.length() != t.length())return false;
        int[] table = new int[26];
        for(char c: s.toCharArray()) table[c-'a']++;
        for(char c: t.toCharArray()){
            table[c-'a']--;
            if(table[c-'a']<0) return false;
        }
        return true;
    }
}

//time complexity: O(n)
//space complexity: O(1) we use extra space but the table size is constant