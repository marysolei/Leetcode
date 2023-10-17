class Solution {
    public int dominantIndex(int[] nums) {
        //check for null input
        if(nums == null || nums.length==0)return -1;
        int currMax = 0;
        int indexMax = -1;
        for(int i=0;i<nums.length; i++){
            if(currMax<nums[i]){
                currMax = nums[i];
                indexMax = i;
            }
        }
        for(int num: nums){
               if(num != currMax) {
                   if(num*2> currMax) return -1;
               }
            }
        return indexMax;
    }
}