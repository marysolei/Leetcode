class Solution {
    public int pivotIndex(int[] nums) {
     
        //check for null input 
        if(nums == null || nums.length ==0)return 0;
        
        int total = 0;
        int currSum = 0;
        for(int num: nums) total+= num;
        for(int i=0; i<nums.length ; i++){
            if(total-currSum- nums[i] == currSum) return i;
            currSum += nums[i];
        }
        return -1;
    }
}
//time complexity: O(n) and space complexity of O(1)