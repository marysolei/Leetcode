class Solution {
    public int shortestBridge(int[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length==0)return 0;
        //get rows and cols 
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean flag=false;
        HashSet<String> visited = new HashSet<>();
        //go through cells to find first island
        for(int row= 0; row< rows; row++) {
            for(int col=0; col< cols ; col++) {
                if(grid[row][col] ==1){
                    helper(grid, row, col, queue, visited);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        //now that we have the first island in our queue we look for bridge using bfs
        return bridgeFinder(grid,queue,visited);
    }
    public void helper(int[][] grid, int row, int col, Queue<int[]> queue,HashSet<String> visited) {
        //check for edge cases 
        if(row < 0 || col<0 || row>= grid.length || col>= grid[0].length || grid[row][col] ==0 || visited.contains(row+","+col)) return;
        
        queue.add(new int[]{row,col});
        grid[row][col] = 0;
        visited.add(row+","+col);
        helper(grid, row+1, col, queue, visited);
        helper(grid, row-1, col, queue , visited);
        helper(grid, row, col+1, queue , visited);
        helper(grid, row, col-1, queue , visited);
    }
    //length of shortest bridge is equal to the levels of bfs from one island to the other 
    public int bridgeFinder(int[][] grid, Queue<int[]> queue , HashSet<String> visited){
        
        int level = 0;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i< size; i++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int newX = curr[0]+dir[0];
                    int newY = curr[1]+dir[1];
                    if(newX >= 0 && newY >= 0 && newX < grid.length && newY< grid[0].length && !visited.contains(newX+","+newY)){
                        if(grid[newX][newY] == 1) return level;
                        else {
                            queue.add(new int[]{newX, newY});
                            visited.add(newX+","+newY);
                        }
                        
                    }
                }
            }
            level++;
            
        }
        return -1;
    }
}