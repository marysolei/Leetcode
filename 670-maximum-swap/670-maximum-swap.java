class Solution {
    public int maximumSwap(int num) {
        
        if(num == 0)return 0;
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int[] maxIndex = new int[n];
        int maxPos = n-1;
        maxIndex[maxPos] = maxPos;
        for(int i=digits.length-2; i>= 0 ; i--){
            if(digits[i]> digits[maxPos]){
                 maxPos=i;
            }
            maxIndex[i]= maxPos;
        }
        for(int i=0; i< n; i++){
            //If there is number higher than current number in the right, swap it
            if(digits[i] != digits[maxIndex[i]]){
                char tmp = digits[i];
                digits[i] = digits[maxIndex[i]];
                digits[maxIndex[i]] = tmp;
                return Integer.parseInt(String.valueOf(digits));
            }
        }
        return num;
    }
}

/*scan the digits backward and record the position of the largest digit when it first appears.Next time we scan the digits from left to right and find the first digit that is less than max to do the swap.
*/