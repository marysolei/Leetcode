class Solution {
    public int uniquePaths(int m, int n) {
        
        //check for null input 
        if(m*n ==0) return 0;
        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        for(int r=0; r< m; r++) memo[r][0] =1;
        for(int c=0; c< n; c++) memo[0][c] =1;
        
        for(int r=1; r< m ; r++){
            for(int c=1; c< n; c++){
                memo[r][c] = memo[r-1][c]+ memo[r][c-1];
            }
        }
        return memo[m-1][n-1];
    }
}
//Time and space complexity of O(m*n)