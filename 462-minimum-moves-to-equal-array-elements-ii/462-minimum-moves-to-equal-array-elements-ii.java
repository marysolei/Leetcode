class Solution {
    public int minMoves2(int[] nums) {
        //check for null input 
        if(nums == null || nums.length ==0)return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int res = 0;
        while(left<right){
            res += nums[right]-nums[left];
            left++;
            right--;
        }
        return res;
    }
}
//Time complexity: O(nlogn) because of sorting 
//space complexity: O(1)