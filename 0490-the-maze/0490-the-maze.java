class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //check for null input 
        if(maze == null || maze.length ==0)return false;
        if(start[0] == destination[0] && start[1] == destination[1])return true;
        if(maze[start[0]][start[1]] ==1) return false;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        int[][] dirs = new int[][]{{0,1},{1,0}, {0,-1}, {-1,0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
            
            for(int[] dir: dirs){
                int newRow = dir[0]+ curr[0];
                int newCol = dir[1]+ curr[1];
                while(newRow>=0 && newRow<maze.length && newCol >= 0 && newCol<maze[0].length && maze[newRow][newCol] ==0) {
                    newRow += dir[0];
                    newCol += dir[1];
                }
                if(!visited[newRow-dir[0]][newCol-dir[1]]){
                    visited[newRow-dir[0]][newCol-dir[1]] = true;
                    queue.add(new int[]{newRow-dir[0], newCol-dir[1]});
                }
            }
        }
        return false;
    }
}