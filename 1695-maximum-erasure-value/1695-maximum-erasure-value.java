class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
       //check for null input 
        if(nums == null || nums.length ==0)return 0;
        if(nums.length ==1)return nums[0];
        
        int left = 0;
        int res = 0;
        int currSum = 0;
        //a hashset to record the unique numbers
        HashSet<Integer> hset = new HashSet<>();
        
        for(int right = 0; right<nums.length ; right++){
            while(hset.contains(nums[right])){
                hset.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            currSum+= nums[right];
            hset.add(nums[right]);
            res = Math.max(res, currSum);
        }
        return res;
    }
}
//Time complexity: O(n) where n is the number of elements in nums
//space complexity: O(m) where m is the number of unique numbers