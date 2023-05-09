class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        if(nums == null || nums.length ==0)return 0;
        int maxCnt=0;
        int currCnt = 0;
        for(int num : nums){
            if(num == 1){
                currCnt++;
            }else{
                maxCnt = Math.max(maxCnt, currCnt);
                currCnt=0;
            }
        }
        return Math.max(maxCnt, currCnt);
    }
}