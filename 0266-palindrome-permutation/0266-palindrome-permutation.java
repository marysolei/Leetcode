class Solution {
    public boolean canPermutePalindrome(String s) {
        
        if(s == null || s.length() ==0) return false;
        int[] freqArr = new int[26];
        for(char c : s.toCharArray()){
            freqArr[c-'a']++;
        }
        boolean found = false;
        for(int i=0;i<freqArr.length;i++){
            if(freqArr[i]%2==0){
                continue;
            }else if(freqArr[i] %2 == 1) {
                if(found) return false;
                found = true;
        }
    }
        return true;
    }
}