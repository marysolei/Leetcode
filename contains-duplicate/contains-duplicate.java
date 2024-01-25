class Solution {
    public boolean containsDuplicate(int[] nums) {
        //check for null input 
        if(nums == null || nums.length ==0)return false;
        HashSet<Integer> numSet = new HashSet<>();
        for(int num: nums){
            if(numSet.contains(num)) return true;
            numSet.add(num);
        }
        return false;
    }
}
//time and space complexity: O(n)