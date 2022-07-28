class Solution {
    public boolean isAnagram(String s, String t) {
        //check for edge cases
        if(s.length() != t.length()) return false;
        int[] mapping = new int[26];
        
        for(char c: s.toCharArray()){
            mapping[c-'a']++;
        }
        for(char c: t.toCharArray()){
            mapping[c-'a']--;
            if(mapping[c-'a'] < 0)return false;
        }
        return true;
    }
}
//Time complexity: O(n)
//space complexity: O(1) because the space that we are using is constant size