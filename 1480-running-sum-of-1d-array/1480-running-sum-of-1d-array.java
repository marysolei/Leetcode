class Solution {
    public int[] runningSum(int[] nums) {
        
        //check for null input 
        if(nums == null || nums.length ==0)return nums;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i=1; i< nums.length; i++){
            res[i] = nums[i] + res[i-1];
        }
        return res;
    }
}
//Time and Space complexity of O(n)