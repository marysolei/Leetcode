class Solution {
    public int singleNumber(int[] nums) {
        //check for null input 
        if(nums.length == 1) return nums[0];
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }
}

//Time complexity: O(n) 
//Space complexity: O(1)