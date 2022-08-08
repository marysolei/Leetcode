class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //check for null input 
        if(coins == null || amount == 0)return 0;
        Arrays.sort(coins);
        //get a memory to track the number of coins
        int[] dp = new int[amount+1];
        //give max value to the memory 
        Arrays.fill(dp, amount+1);
        dp[0]= 0;

        for(int i=0; i<= amount; i++){
            for(int coin: coins){
                if(coin>i) break;
                else {
                    dp[i] = Math.min(dp[i], dp[i-coin] +1);
                }
            }
        }
        return dp[amount]== amount+1? -1 : dp[amount];
    }
}

//Time complexity: O(amount*n) where n is the coin array length
//Space complexity: O(amount)