class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length ==0)return 0;
        //get rows and cols 
        int rows = grid.length; 
        int cols = grid[0].length;
        int area = 0;
        int maxArea = 0;
        for(int row = 0; row< rows; row++){
            for(int col =0; col< cols; col++) {
                if(grid[row][col] ==1){
                    area = helper(grid, row, col,1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
    public int helper(int[][] grid, int row, int col, int area) {
        //check for edge cases 
        if(row<0 || row>= grid.length || col<0 || col>= grid[row].length || grid[row][col] ==0) return 0;
        
        //mark as visited
        grid[row][col] = 0;
        area += helper(grid, row+1,col, area) +
                helper(grid, row-1,col, area) +
                helper(grid, row,col+1, area) +
                helper(grid, row,col-1, area) ;
        return area;
    }
}