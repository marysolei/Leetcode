class Solution {
    public int firstUniqChar(String s) {
     
        if(s == null || s.length() ==0)return -1;
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c: s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        for(int i=0;i< s.length(); i++) {
            if(countMap.get(s.charAt(i)) ==1)return i;
        }
        return -1;
    }
}
//time and space complexity:O(n)