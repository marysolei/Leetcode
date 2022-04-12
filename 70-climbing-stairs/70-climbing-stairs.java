class Solution {
    public int climbStairs(int n) {
        
        //check for base cases
        if(n == 0 || n == 1)return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

/*Time complexity : O(n) Single loop upto n.
Space complexity : O(n). dp array of size n is used.*/
