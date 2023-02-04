class Solution {
    public int firstUniqChar(String s) {
        
        if(s == null || s.length() ==0) return -1;
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        for(int i=0; i< s.length(); i++)hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
        
        for(int i=0; i< s.length(); i++) if(hmap.get(s.charAt(i)) ==1) return i;
        return -1;
    }
}

//Time and space complexity: O(n)