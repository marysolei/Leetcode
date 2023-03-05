class Solution {
    public int maxNumberOfBalloons(String text) {
        
        if(text == null)return 0;
        String key = "balloon";
        return helper(text, key);
    }
    public int helper(String text, String key){
        
        int[] textFreq = new int[26];
        int[] keyFreq = new int[26];
        int min = Integer.MAX_VALUE;
        for(char c: text.toCharArray()) textFreq[c-'a']++;
        for(char c: key.toCharArray()) keyFreq[c-'a']++;
        for(int i=0; i< 26; i++) {
          if(keyFreq[i]>0)  min = Math.min(min, textFreq[i]/keyFreq[i]);
        }
        return min;
    }
}