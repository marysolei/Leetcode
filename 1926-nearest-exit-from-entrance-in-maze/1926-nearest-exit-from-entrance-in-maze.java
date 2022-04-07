class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        if(maze == null || maze.length ==0 || entrance == null)return -1;
        int rows = maze.length;
        int cols = maze[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {entrance[0], entrance[1], 1});
        HashSet<String> visited = new HashSet<>();
        visited.add(entrance[0]+","+entrance[1]);
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int newX = curr[0]+dir[0];
                int newY = curr[1]+dir[1];
                if( newX>= 0 && newY >= 0 && newX< maze.length && newY < maze[0].length && maze[newX][newY]=='.' && !visited.contains(newX+","+newY)) {
                    if(newX*newY == 0 || newX== maze.length-1 || newY == maze[0].length -1) {
                        return curr[2];
                    }
                    else {
                        queue.add(new int[]{newX, newY, curr[2]+1});
                        visited.add(newX+","+newY);
                    }
                }
            }    
        }
        return -1;
    }
}