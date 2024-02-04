class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //check for null input 
        if(grid == null || grid.length ==0)return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c] ==1) maxArea = Math.max(maxArea, helper(grid,r,c,1));
            }
        }
        return maxArea;
    }
    public int helper(int[][] grid, int r, int c, int area){
        if(r<0 || r>= grid.length || c<0 || c>= grid[0].length || grid[r][c] ==0) return 0;
        grid[r][c] = 0;
        area += helper(grid, r+1, c, area)+
                helper(grid, r-1, c, area)+ 
                helper(grid, r, c+1, area)+ 
                helper(grid, r, c-1, area);
        return area;
    }
}
/*Time Complexity: O(R∗C), where R is the number of rows in the given grid, and 
C is the number of columns. We visit every square once.
Space complexity: O(R∗C), the space used by seen to keep track of visited squares and the space used by the call stack during our recursion.*/