class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        //check for null input and edge cases
        if(obstacleGrid == null || obstacleGrid.length ==0)return 0;
        if(obstacleGrid[0][0] == 1)return 0;
        //get rows and cols 
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0]= 1;
        //fill in the first col
        for(int r=1; r< rows; r++){
            //if there is no obstacle
            if(obstacleGrid[r][0] == 0 && dp[r-1][0]==1) dp[r][0] = 1;
            else dp[r][0]= 0;
        }        
        //fill in the first row
        for(int c=1; c< cols; c++){
            //if there is no obstacle
            if(obstacleGrid[0][c] ==0 && dp[0][c-1] ==1) dp[0][c] = 1;
            else dp[0][c] = 0;
        }
        //fill in the rest of the grid moving only to the right and down
        for(int r=1; r< rows; r++){
            for(int c=1; c< cols; c++) {
                if(obstacleGrid[r][c] == 0) {
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                }else dp[r][c] =0;
            }
        }
        return dp[rows-1][cols-1];
    }
}