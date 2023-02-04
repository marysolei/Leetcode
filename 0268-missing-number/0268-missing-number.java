class Solution {
    public int missingNumber(int[] nums) {
        
        if(nums == null || nums.length ==0)return 0;
        int currSum = 0;
        int totalSum = 0;
        for(int num : nums) currSum += num;
        for (int i=0; i<= nums.length; i++) totalSum += i;
        return totalSum - currSum;
    }
}
//Time complexity: O(n)
//space complexity: O(1)