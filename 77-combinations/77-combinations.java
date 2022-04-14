class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(n == 0)return result;
        List<Integer> arr = new ArrayList<>();
        backtrackHelper(1, arr, result,n, k);
        return result;
    }
    public void backtrackHelper(int first ,List<Integer> arr,List<List<Integer>> result, int n, int k){
        //the combination is done
        if (arr.size() == k) {
            result.add(new ArrayList<>(arr));
        }
        for(int i=first; i<n+1; i++){
            //add i into curr combination
            arr.add(i);
            //use next int to complete the combination
            backtrackHelper(i+1, arr, result, n,k);
            //backtrack
            arr.remove(arr.size()-1);
        }
    }
}