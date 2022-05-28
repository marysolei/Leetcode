class Solution {
    public int missingNumber(int[] nums) {
        
        int res =nums.length;
        //check edge cases 
        if (nums == null || nums.length ==0)return -1;
        
        //go through the numbers to find the missing one 
        for (int i =0; i< nums.length ; i++) {
            res = res^(nums[i]^i);
        }
        return res;
    }
}