class Solution {
    public int maxNumberOfBalloons(String text) {
        if(text == null || text.length() ==0) return 0;
        char[] textArr = new char[26];
        char[] keyArr = new char[26];
        String key ="balloon";
        for (char c: key.toCharArray()) keyArr[c-'a']++;
        for (char c: text.toCharArray()) textArr[c-'a']++;
        int min = Integer.MAX_VALUE;
        for(int i=0; i< 26; i++){
            if(keyArr[i]>0) min = Math.min(min, textArr[i]/keyArr[i]);
        }
        return min==Integer.MAX_VALUE? 0: min;
    }
}
//time complexity: O(n)
//space complexity:O(1)