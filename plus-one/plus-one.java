class Solution {
    public int[] plusOne(int[] digits) {
        //check for null input 
        if(digits == null || digits.length ==0)return digits;
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] ==9){
                digits[i] = 0;
            }else{
                digits[i] = digits[i]+1;
                return digits;
            }
        }
       int[] res = new int[digits.length+1];
        res[0]=1;
        return res;
    }
}
/*Algorithm

Move along the input array starting from the end of array.

Set all the nines at the end of array to zero.

If we meet a not-nine digit, we would increase it by one. The job is done - return digits.

We're here because all the digits were equal to nine. Now they have all been set to zero. We then append the digit 1 in front of the other digits and return the result.
*/
//Time and space complexity: O(n) 