class Solution {
    public int missingNumber(int[] nums) {
        
        int currSum = 0;
        int totalSum= 0;
        for(int i=0; i<=nums.length ; i++) totalSum+= i;
        for(int num: nums) currSum += num;
        return totalSum-currSum;
    }
}