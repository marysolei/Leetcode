class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums == null || nums.length ==0)return -1;
        int index = 1;
        for(int i=1; i< nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}