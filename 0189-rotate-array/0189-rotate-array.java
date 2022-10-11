class Solution {
    public void rotate(int[] nums, int k) {
        
        //check for null input 
        if(nums == null || nums.length ==0) return ;
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start<= end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
//Time complexity: O(n) and space complexity: O(1)

/*Original List                   : 1 2 3 4 5 6 7
  After reversing all numbers     : 7 6 5 4 3 2 1
  After reversing first k numbers : 5 6 7 4 3 2 1
  After reversing last n-k numbers : 5 6 7 1 2 3 4 --> Result*/