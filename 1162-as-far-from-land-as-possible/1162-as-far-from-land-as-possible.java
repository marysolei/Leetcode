class Solution {
    public int maxDistance(int[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length == 0)return -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int level = 0;
        
        //make a queue of land cells 
        for(int r=0;r< rows; r++){
            for(int c=0; c< cols; c++){
                if(grid[r][c] == 1){
                    queue.add(new int[]{r,c});
                }
            }
        }
        //if there is no water 
        if(queue.size() == rows*cols)return -1;
        
        //standard bfs
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i< size ; i++) {
                
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                int newX = dir[0]+curr[0];
                int newY = dir[1]+curr[1];
                if(newX>= 0 && newY>= 0 && newX< rows && newY< cols && grid[newX][newY] ==0){
                    grid[newX][newY] = 1;
                    queue.add(new int[]{newX, newY});
                }
            }
            }
            level++;
        }
        return level-1;
    }
}
//the answer is the number of the levels of bfs so the max distance from water is the level of bfs