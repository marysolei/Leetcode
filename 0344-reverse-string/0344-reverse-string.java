class Solution {
    public void reverseString(char[] s) {
        
        //check for null input 
        if(s == null || s.length ==0)return;
        int left =0;
        int right = s.length-1;
        char tmp;
        while(left<right){
            tmp = s[left];
            s[left] = s[right];
            s[right]= tmp;
            left++;
            right--;
        }
    }
}
//Time complexity: O(n)
//space complexity: O(1)