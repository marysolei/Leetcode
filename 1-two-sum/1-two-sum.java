class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if(nums == null || nums.length ==0)return nums;
        HashMap<Integer, Integer> hmap  = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(hmap.containsKey(nums[i]) && i != hmap.get(nums[i])){
                return new int[]{i, hmap.get(nums[i])};
            }else {
                hmap.put(target-nums[i],i);
            }
        }
        return null;
    }
}