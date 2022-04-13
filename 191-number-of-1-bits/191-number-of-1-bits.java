public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int result = 0;
        int mask = 1;
        for(int i=0; i< 32; i++){
            if((n & mask) !=0 ) result++;
            mask<<= 1;
        }
        return result;
    }
}
/* From Leetcode: We check each of the 32 bits of the number. If the bit is 1, we add one to the number of 1-bits.
We can check the i th bit of a number using a bit mask. We start with a mask m=1, because the binary representation of 1 is,
00000000000000000000000000000001 Clearly, a logical AND between any number and the mask 1 gives us the least significant bit of this number. To check the next bit, we shift the mask to the left by one.
00000000000000000000000000000010
And so on.*/
//Time and space complexity O(1)