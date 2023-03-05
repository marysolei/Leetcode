class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //check for null input
        if(magazine == null || magazine.length() ==0)return false;
        if(ransomNote.length()> magazine.length()) return false;
        HashMap<Character,Integer> hmap = new HashMap<>();
        
        for(char c: magazine.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        } 
        for(char c: ransomNote.toCharArray()){
            if(!hmap.containsKey(c) || hmap.get(c)<=0) return false;
            hmap.put(c, hmap.get(c)-1);
        }
        return true;   
    }
}
//Time Complexity: O(M+R) where M is the number of chars in magazine and R is the number of chars in ransomNote
//Space Complexity: O(M) hashmap of chars in magazine