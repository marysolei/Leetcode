class Solution {
    public int[] sortedSquares(int[] nums) {
        
        //check for null input 
        if(nums == null || nums.length ==0) return nums;
        int left = 0;
        int right = nums.length-1;
        int n = nums.length;
        int[] res = new int[nums.length];
        for(int i=n-1; i>=0 ; i--){
            int square;
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                square = nums[right];
                right--;
            }else {
                square = nums[left];
                left++;
            }
            res[i]= square*square;
        }
        return res;
    }
}