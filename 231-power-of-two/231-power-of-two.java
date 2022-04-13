class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n ==0)return false;
        long x = (long) n;
        return (x&(-x)) ==x;
    }
}
/*a power of two in binary representation is one 1-bit, followed by some zeros.A number which is not a power of two, has more than one 1-bit in its binary representation.The only exception is 0, which should be treated separately.
x & (-x) is a way to keep the rightmost 1-bit and to set all the other bits to 0. −x is the same as ¬x+1. This operation reverts all bits of x except the rightmost 1-bit. */

//Time complexity :O(1).
//Space complexity : O(1).