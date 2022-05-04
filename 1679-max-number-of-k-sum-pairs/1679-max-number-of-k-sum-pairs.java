class Solution {
    public int maxOperations(int[] nums, int k) {
        
        //check for null input 
        if(nums == null || nums.length ==0)return 0;
        //make a map of array elements and their complement
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int res = 0;
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int complement = k-nums[i];
            //if we have complement
            if(hmap.getOrDefault(complement,0)>0){
                //remove it from the map 
                hmap.put(complement, hmap.get(complement)-1);
                res++;
            }else {
                hmap.put(curr, hmap.getOrDefault(curr,0)+1);
            }
        }
        return res;
    }
}

//Time and Space complexity of O(n) where n is the number of elements in array nums