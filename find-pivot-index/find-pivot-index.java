class Solution {
    public int pivotIndex(int[] nums) {
        //check for null input 
        if(nums == null || nums.length == 0)return -1;
        int totalSum = 0;
        for(int num: nums) totalSum += num;
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if(totalSum - currSum == currSum- nums[i])return i;
        }
        return -1;
    }
}

//Time complexity: O(n)
//space complexity: O(1)