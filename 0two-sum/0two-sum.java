class Solution {
    public int[] twoSum(int[] nums, int target) {
        //check for null input 
        if(nums == null || nums.length ==0)return nums;
        HashMap<Integer, Integer> mapping = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            mapping.put(target-nums[i], i);
        }
        int[] res = new int[2];
        for(int i=0; i< nums.length; i++){
            if(mapping.containsKey(nums[i]) && mapping.get(nums[i]) != i){
                res[0] = i;
                res[1] = mapping.get(nums[i]);
            }
        }
        return res;
    }
}
//Time and complexity: O(n)