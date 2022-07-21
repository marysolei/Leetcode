class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        // check for null input 
        if(cost == null || cost.length ==0)return 0;
        int[] memo = new int[cost.length+1];
        
        //memo[0]= Math.min(cost[0], cost[1]);
        for(int i=2; i< memo.length; i++){
            memo[i] = Math.min(memo[i-1]+cost[i-1], cost[i-2]+ memo[i-2]);
        }
        return memo[memo.length-1];
    }
}