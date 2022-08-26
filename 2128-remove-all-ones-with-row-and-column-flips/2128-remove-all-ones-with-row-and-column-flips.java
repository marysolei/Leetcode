class Solution {
    public boolean removeOnes(int[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length ==0)return false;
        
        int rows = grid.length;
        int cols = grid[0].length;
        for(int c=0; c<cols; c++) if(grid[0][c] == 1)flipCol(c, grid);
        
        for(int r=1; r< rows; r++){
            for(int c=1; c< cols; c++){
                if(grid[r][c] != grid[r][c-1]) return false;
            }
        }
        return true;
    }
    public void flipCol(int c, int[][] grid){
        
        for(int r=0; r< grid.length; r++){
            grid[r][c] = 1- grid[r][c];
        }
    }
}
/* From Leetcode: Let's say there are some number of 1s in the first row. To get to all 0s matrix it is 
obvious that we must flip those 1s. If we flip the first row itself then any 0 will turn into 
1. So instead we flip all the columns that have 1 in the first row. Now if we think, we can 
realize that we can never flip columns again, because if we do, then 0s in first row will turn 
to 1s again. So our only option is to flip rows now (starting from second row since first row 
is already all 0s). Now to get all 0s in the final matrix each row should have either only 0s 
or only 1s. If it has only 0s we don't flip it, if it has only 1s then we flip it. If in any 
row all the elements are not same, it means it is not possible to get all 0s matrix.*/