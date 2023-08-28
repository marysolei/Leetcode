class Solution {
    public boolean isIsomorphic(String s, String t) {
        //check for null input
        if(s == null || t== null)return s==t;
        if(s.length() != t.length())return false;
        
        HashMap<Character, Character> hmap = new HashMap<>();
        for(int i=0;i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(hmap.containsKey(c1)){
                if(hmap.get(c1) != c2) return false;
            }else {
                if(hmap.containsValue(c2)) return false;
            }
            hmap.put(c1, c2);
        }
        return true;
    }
}