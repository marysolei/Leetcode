class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        //check for null input 
        if(heights == null || heights.length ==0)return 0;
        //get rows and cols
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        //queue for bfs 
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        queue.add(new int[]{0,0,0});
        boolean[][] visited = new boolean[rows][cols];
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            //if we are at the rightmost cell
            if(curr[0] == rows-1 && curr[1] ==cols-1) return curr[2];
            if(visited[curr[0]][curr[1]]) continue;
            visited[curr[0]][curr[1]] = true; //mark the cell as visited
            
            for(int[] dir : dirs){
                int newRow = dir[0]+ curr[0];
                int newCol = dir[1]+ curr[1];
                if(newRow>=0 && newCol>= 0 && newRow< rows && newCol < cols) {
                    queue.add(new int[]{newRow, newCol, Math.max(curr[2], Math.abs(heights[newRow][newCol] - heights[curr[0]][curr[1]]))});
                }
            }
        }
        return -1;
    }
}