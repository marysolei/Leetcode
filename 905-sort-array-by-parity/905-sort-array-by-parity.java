class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        //check for null input 
        if(nums == null || nums.length ==0)return nums;
        int index =0;
    
        for(int i=0;i< nums.length ; i++) {
            if(nums[i] % 2 == 0){
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i]= tmp;
                index++;
            }
        }
        return nums;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)