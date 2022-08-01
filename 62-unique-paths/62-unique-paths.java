class Solution {
    public int uniquePaths(int m, int n) {
        
        //check for null input
        if(m *n ==0)return 0;
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for(int r=1; r<m; r++) grid[r][0] = 1;
        for(int c=1; c<n ; c++)grid[0][c] = 1;
        for(int r=1; r< m; r++){
            for(int c=1; c<n; c++){
                grid[r][c] = grid[r-1][c] + grid[r][c-1];
            }
        }
        return grid[m-1][n-1];
    }
}
//Time and space complexity of O(m*n)