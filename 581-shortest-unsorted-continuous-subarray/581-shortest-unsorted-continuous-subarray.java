class Solution {
    public int findUnsortedSubarray(int[] nums) {
       
        Stack<Integer> stack = new Stack<>();
        int left = nums.length;
        int right = 0;
        for(int i=0; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        if(right-left>0) return right-left+1;
        return 0;
    }
}
//Time and space complexity O(n) where n is the number of elements in nums