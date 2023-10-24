class Solution {
    public void reverseString(char[] s) {
        //check for null input 
        if(s == null || s.length ==0)return;
        int left = 0;
        int right = s.length-1;
        while(left<right){
            swap(s, left, right);
            left++;
            right--;
        }
    }
    public void swap(char[] s, int left, int right){
        if(left> right) return;
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }
}
//Time complexity:O(n)
//space complexity:O(1)