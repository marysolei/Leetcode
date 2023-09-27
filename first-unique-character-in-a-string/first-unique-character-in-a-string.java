class Solution {
    public int firstUniqChar(String s) {
        //check for null input 
        if(s == null || s.length() ==0)return -1;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char c: s.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        }
        for(int i=0; i<s.length(); i++){
            if(hmap.get(s.charAt(i)) ==1) return i;
        }
        return -1;
    }
}
//Time and Space complexity: O(n)