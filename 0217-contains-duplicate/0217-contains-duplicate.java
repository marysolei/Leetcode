class Solution {
    public boolean containsDuplicate(int[] nums) {
        
         if(nums == null || nums.length ==0)return false;
        HashSet<Integer> hset = new HashSet<>();
        for(int num : nums){
            if(hset.contains(num))return true;
            hset.add(num);
        }
        return false;
    }
}