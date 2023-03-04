class Solution {
    public int minStartValue(int[] nums) {
        
        if(nums == null || nums.length ==0) return 1;
        int currSum = 0;
        int minVal = 0;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            minVal = Math.min(minVal, currSum);
        }
        return (minVal>=0)? 1:(-1*minVal)+1;
    }
}
//Time complexity: O(n)
//space complexity: O(1)