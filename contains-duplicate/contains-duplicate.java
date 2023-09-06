class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        //check for null input 
        if(nums == null || nums.length ==0) return false;
        HashSet<Integer> hset = new HashSet<>();
        for (int num : nums){
            if(hset.contains(num)) return true;
            hset.add(num);
        }
        return false;
    }
}
//Time and space complexity: O(n)