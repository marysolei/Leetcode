class Solution {
    public int numIslands(char[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length ==0)return 0;
        //get rows and cols 
        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands =0;
        
        for(int r=0; r< rows; r++){
            for(int c=0; c< cols; c++){
                if(grid[r][c] =='1') {
                    dfsHelper(grid, r, c);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    public void dfsHelper(char[][] grid, int row, int col) {
        
        //check for edge cases
        if(row <0 || col<0 || row>= grid.length || col>= grid[row].length || grid[row][col] == '0')return ;
        
        grid[row][col] = '0';
        dfsHelper(grid, row+1, col);
        dfsHelper(grid, row-1, col);
        dfsHelper(grid, row, col+1);
        dfsHelper(grid, row, col-1);
    }
}
//time and space complexity: O(r*c)