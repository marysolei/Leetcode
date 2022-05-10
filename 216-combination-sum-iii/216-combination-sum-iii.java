class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<Integer>();
        //using backtrack method
        helper(k,n ,result,combination, 1);
        return result;
    }
    
    public void helper(int k, int n, List<List<Integer>> ans, List<Integer> comb,  int index) {
        //base case: if we made a new combination that satisfy the conditions
	if (comb.size() == k && n == 0) {
		List<Integer> li = new ArrayList<Integer>(comb);
		ans.add(li);
		return;
	}
	for (int i = index; i <= 9; i++) {
        //add the value to the combination
		comb.add(i);
        //call func for next value
		helper(k, n-i, ans, comb, i+1);
        //remove the value for backtracking
		comb.remove(comb.size() - 1);
	}
 }
}
/*The trick is that we pick the candidates in order. We treat the candidate digits as a list with order, i.e. 
[1, 2, 3, 4, 5, 6, 7, 8. 9]. At any given step, once we pick a digit, e.g. 6, we will not consider any digits 
before the chosen digit for the following steps, e.g. the candidates are reduced down to [7, 8, 9].*/