class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        Integer candidate = null;
        for(int num : nums){
            if(count == 0) candidate = num;
            if(candidate== num) count++; 
            else count--;
        }
        return candidate;
    }
}
//Time complexity: O(n)
//space complexity: O(1)