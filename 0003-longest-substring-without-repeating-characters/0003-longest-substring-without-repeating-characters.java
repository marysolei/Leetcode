class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() ==0)return 0;
        HashSet<Character> hset = new HashSet<>();
        int left = 0;
        int right =0;
        int res = 0;
        while (right<s.length()){
            if(!hset.contains(s.charAt(right))){
                hset.add(s.charAt(right));
                right++;
            }else {      
                hset.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, hset.size());
        }
        return res;
    }
}