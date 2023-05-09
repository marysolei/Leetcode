class Solution {
    public int removeElement(int[] nums, int val) {
        //check for null input 
        if(nums == null || nums.length ==0)return 0;
        int left = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i]!=val){
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}