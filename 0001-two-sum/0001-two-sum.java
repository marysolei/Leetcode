class Solution {
    public int[] twoSum(int[] nums, int target) {
        //check for null input 
        if(nums== null || nums.length ==0) return nums;
        int[] res = new int[]{-1,-1};
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i< nums.length ;i++) hmap.put(target-nums[i], i);
        for(int i=0; i< nums.length ; i++){
            if(hmap.containsKey(nums[i]) && i!= hmap.get(nums[i])) {
                res[0] = i;
                res[1] = hmap.get(nums[i]);
            }
        }
        return res;
    }
}

//Time and Space complexity: O(n)