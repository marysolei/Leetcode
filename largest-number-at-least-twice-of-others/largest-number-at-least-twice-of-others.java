class Solution {
    public int dominantIndex(int[] nums) {
        
        if(nums == null || nums.length ==0)return -1;
        int maxNum= 0;
        int maxIndex = -1;
        for(int i=0;i<nums.length; i++) {
            if(nums[i]> maxNum){
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        for(int num: nums){
            if(num != maxNum){
                if(num*2> maxNum)return -1;
            }
        }
        return maxIndex;
    }
}