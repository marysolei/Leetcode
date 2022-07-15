class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length ==0)return 0;
        //get rows and cols
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for(int r=0; r<rows; r++) {
            for(int c=0;c<cols; c++){
                //look for a cell which is part of an island
                if(grid[r][c] ==1) {
                    //get the island area
                    int islandArea = helper(grid,r,c,1);
                    res = Math.max(res, islandArea);
                }
            }
        }
        return res;
    }
    public int helper(int[][] grid, int row, int col, int curr){
        //check for edge cases
        if(row<0 || row>= grid.length || col<0 || col>= grid[0].length || grid[row][col] == 0)return 0;
        
        //mark the curr cell as visited
        grid[row][col] = 0;
        //check for 4-directionally neighbors
        curr += helper(grid,row+1, col, curr)+
                helper(grid,row-1, col, curr)+
                helper(grid,row, col+1, curr)+
                helper(grid,row, col-1, curr);
        return curr;
    }
}

//Time complexity of O(r*c)