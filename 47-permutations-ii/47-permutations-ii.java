class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();
        //check for null input 
        if(nums == null || nums.length ==0)return result;
        helper(nums, curr,set, visited);
        
        for(List<Integer> li : set) {
            result.add(new ArrayList<>(li));
        }
        return result;
    }
    public void helper(int[] nums, List<Integer> curr, Set<List<Integer>> set, boolean[] visited){
        if(nums.length == curr.size()){
            set.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i< nums.length; i++){
            if(!visited[i]){
                curr.add(nums[i]);
                visited[i] = true;
                helper(nums, curr, set, visited);
                curr.remove(curr.size()-1);
                visited[i]= false;
            }
            
            
            
        }
    }
}