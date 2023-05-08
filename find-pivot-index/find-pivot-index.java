class Solution {
    public int pivotIndex(int[] nums) {
        //check for null input 
        if(nums == null) return -1;
        int totalSum = 0;
        int currSum =0;
        for (int num : nums) totalSum += num;
        for(int i=0;i<nums.length; i++){
            if(currSum == totalSum-currSum- nums[i]) return i;
            currSum += nums[i];
        }
        return -1;
    }
}
//time complexity: O(n) and space complexity of O(1)