class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        //check for null input 
        if(mat == null || mat.length ==0)return mat;
        
        int rows = mat.length; 
        int cols = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int r=0; r< rows; r++) {
            for(int c=0; c< cols; c++){
                if(mat[r][c] ==0){
                    queue.add(new int[]{r,c});
                }else mat[r][c] = Integer.MAX_VALUE;
            }
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int newX = dir[0]+curr[0];
                int newY = dir[1]+curr[1];
                if(newX>= 0 && newY>= 0 && newX<rows && newY <cols && mat[newX][newY] > mat[curr[0]][curr[1]]+1){
                    queue.add(new int[]{newX,newY});
                    mat[newX][newY] = mat[curr[0]][curr[1]]+1;
                }
            }
        }
       return mat;
        
    }
}
//we start the BFS from 0s and thereby, updating the distances of all the 1s in the path.
/* For our BFS routine, we keep a queue, q to maintain the queue of cells to be examined next.
   We start by adding all the cells with 0s to q.
   Intially, distance for each 0 cell is 0 and distance for each 1 is INT_MAX, which is updated during the BFS.
   Pop the cell from queue, and examine its neighbors. If the new calculated distance for neighbor {i,j} is smaller, we add {i,j} to q and update dist[i][j].*/

//Time and Space complexity: O(r*c)