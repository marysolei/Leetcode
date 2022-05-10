class Solution {
    public int[] sumZero(int n) {
        
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        int curr = 1;
        while(left<right){
            res[left++] = curr;
            res[right--]= -curr;
            curr++;
        }
        return res;
    }
}