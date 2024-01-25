class Solution {
    public int[] twoSum(int[] nums, int target) {
        //check for null input 
        if (nums == null || nums.length ==0)return nums;
        int[] res = new int[]{-1,-1};
        HashMap<Integer, Integer> mapping = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            if(mapping.containsKey(nums[i]) && mapping.get(nums[i])!=i){
                res[0]= i;
                res[1]= mapping.get(nums[i]);
                return res;
            }
            mapping.put(target-nums[i],i);     
        }
        return res;
    }
}

//time and space complexity: O(n)