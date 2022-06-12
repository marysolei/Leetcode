class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        if(nums == null)return 0;
        if(nums.length ==0)return nums[0];
        int left = 0;
        int sum =0;
        int res = 0;
        HashSet<Integer> hset = new HashSet<>();
       
        for(int right = 0; right<nums.length; right++){
            while(hset.contains(nums[right])){
                hset.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
             sum+= nums[right];
            hset.add(nums[right]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
