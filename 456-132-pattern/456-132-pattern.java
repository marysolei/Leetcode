class Solution {
    public boolean find132pattern(int[] nums) {
        
        //check for null input 
        if(nums == null || nums.length ==0)return false;
        int[] min = new int[nums.length];
        min[0]= nums[0];
        for(int j=1; j< nums.length ; j++){
            min[j] = Math.min(min[j-1], nums[j]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i= nums.length-1; i>=0 ;i--){
            while(!stack.isEmpty() && stack.peek() <nums[i]){
                if(stack.peek() > min[i]) return true;
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
//Time and space complexity : O(n)