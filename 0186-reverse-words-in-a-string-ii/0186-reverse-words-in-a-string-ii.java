class Solution {
    public void reverseWords(char[] s) {
        //check for null input 
        if(s == null || s.length == 0)return;
        //reverse the whole string
        reverse(s, 0, s.length-1);
        //reverse each word
        reverseEachWord(s);
    }
    public void reverse(char[] s, int start, int end){
        while(start<end){
            char tmp = s[start];
            s[start++]= s[end];
            s[end--]= tmp;
        }
    }
    public void reverseEachWord(char[] s){
        int len = s.length;
        int start=0, end = 0;
        while(start<len){
            while(end<len && s[end]!= ' ') end++;
            //reverse the word
            reverse(s, start, end-1);
            //move to next word
            start= end+1;
            end++;
        }
    }
}

//Time complexity: O(n)
//space complexity: O(1)