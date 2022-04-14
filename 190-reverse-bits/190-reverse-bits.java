public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
    int res =0;
      for (int i = 0; i < 32; i++ ){
		//num&1 => get the lowest bit of num
		//append that bit to the right of res
		res = res<<1 | n&1;
		//right shift
		n >>= 1;
	}
	return res;
    }
}