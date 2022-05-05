class Solution {
    //4-directions 
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        
        //check for null input 
        if(matrix == null || matrix.length ==0)return 0;
        //get rows and cols
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxDis = 1;
        int[][] cache = new int[rows][cols]; // to cache the max distance so far
        //call a dfs for each cell
        for(int r=0; r< rows ; r++) {
            for(int c=0; c< cols; c++){
                int len = dfs(matrix, r,c, cache);
                maxDis = Math.max(maxDis, len);
            }
        }
        return maxDis;
    }
    public int dfs(int[][] matrix, int row, int col, int[][] cache){
        //if we already visited this cell
        if(cache[row][col] != 0) return cache[row][col];
        int max = 1;
        //explore neighbors
        for(int[] dir : dirs){
            int newRow = dir[0]+ row;
            int newCol = dir[1]+ col;
            //check that new cell is within the matrix and has a greater value than previous cell
            if(newRow>= 0 && newCol>=0 && newRow<matrix.length && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[row][col]){
                int len = 1+ dfs(matrix, newRow, newCol, cache);
                max = Math.max(max, len);
            }
        }
        cache[row][col] = max;
        return max;
    }
}
//Time and space complexity: O(mn)