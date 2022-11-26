class Solution {
    public int numIslands(char[][] grid) {
        //check for null input 
        if(grid == null || grid.length ==0) return 0;
        int rows = grid.length; 
        int cols = grid[0].length;
        int numIslands = 0;
        for(int r=0; r< rows; r++){
            for(int c= 0; c< cols; c++){
                if(grid[r][c] =='1') {
                    helper(grid, r, c);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    public void helper(char[][] grid, int row, int col){
        
        //check edge cases
        if(row<0 || row>= grid.length || col<0 || col>= grid[0].length || grid[row][col] =='0') return;
        //mark as visited 
        grid[row][col] ='0';
        helper(grid, row+1, col);
        helper(grid, row-1, col);
        helper(grid, row, col-1);
        helper(grid, row, col+1);
    }
}

//time and space complexity: O(r*c)