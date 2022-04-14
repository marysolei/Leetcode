class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length ==0)return result;
        List<Integer> curr = new ArrayList<>();
        helper(nums, result, curr, 0);
        return result;
    }
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> curr, int index){
        //if we get to the end of this combination
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i= 0; i< nums.length; i++ ){
            if (curr.contains(nums[i]))continue;
            curr.add(nums[i]);
            //call func for other combinations
            helper(nums, result, curr, i+1);
            //backtrack
            curr.remove(curr.size()-1);
        }
    }
}