class Solution {
    public int fib(int n) {
        
        if(n == 0 || n == 1)return n;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2; i<=n; i++){
            memo[i]= memo[i-1]+memo[i-2];
        }
        return memo[n];
    }
}
//Time and Space complexity of O(n)