class Solution {
    public int searchInsert(int[] nums, int target) {
     
        //check for null input
        if(nums == null || nums.length ==0)return 0;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left +(right-left)/2;
            if(nums[mid] == target)return mid;
            else if (nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}