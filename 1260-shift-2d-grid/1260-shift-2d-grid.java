class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        //check for null input 
        if(grid == null || grid.length ==0)return null;
        int rows = grid.length;
        int cols = grid[0].length;
        
        while(k>0){
            
            //write the grid to a new 2D array 
            int[][] newGrid = new int[rows][cols];
            
            //case1: move everything except the last col
            for(int r=0; r< rows; r++){
                for(int c=0; c< cols-1; c++){
                    newGrid[r][c+1] = grid[r][c];
                }
            }
            
            //case 2: move everything in last col but not last row 
            for(int r=0; r< rows-1; r++){
                newGrid[r+1][0] = grid[r][cols-1];
            }
            
            //case 3: move the bottom right
            newGrid[0][0] = grid[rows-1][cols-1];
            grid = newGrid;
            k--;
        }
        List<List<Integer>>  result = new ArrayList<>();
        for(int[] row : grid) {
            List<Integer> currRow = new ArrayList<>();
            result.add(currRow);
            for(int num : row)currRow.add(num);
        }
        return result;
    }
}

//Time complexity : O(r*c*k)
//space complexity: O(r*c) creating a new grid with r rows and c cols