class Solution {
    public int orangesRotting(int[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length ==0)return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> rottenOranges = new ArrayDeque<>();
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int maxMinute = 0;
        
        //fill the queue with all rotten oranges
        for(int r=0; r< rows; r++) {
            for(int c=0 ; c< cols ; c++) {
                if(grid[r][c] == 2){
                    rottenOranges.add(new int[]{r,c,0});
                }
            }
        }   
        //bfs through neighbors to see when each will be rotten
        while(!rottenOranges.isEmpty()){
            int[] curr = rottenOranges.poll();
            maxMinute = Math.max(maxMinute, curr[2]);
            for(int[] dir : dirs) {
                int newRow = dir[0]+ curr[0];
                int newCol = dir[1]+curr[1];
                if(newRow >= 0 && newCol>= 0 && newRow<rows && newCol< cols && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol]= 2;
                    rottenOranges.add(new int[]{newRow, newCol, curr[2]+1});
                    }
                }
            }
        //check if there is a cell left with value 1
        for(int r=0; r< rows; r++) {
            for(int c=0; c< cols; c++) {
                if(grid[r][c] == 1)return -1;
            }
        }
        return maxMinute;
    }
}

//Time and space complexity: O(r*c)