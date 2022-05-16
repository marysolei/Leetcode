class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length ==0)return 0;
        if(grid[0][0]==1)return -1;
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        HashSet<String> visited = new HashSet<>();
        visited.add("0,0");
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0] == n-1 && curr[1] == n-1) return curr[2];
            
            for(int[] dir : dirs){
                int newRow = dir[0]+ curr[0];
                int newCol = dir[1]+ curr[1];
                if(newRow>= 0 && newCol>= 0 && newRow< n && newCol< n && grid[newRow][newCol] == 0 && !visited.contains(newRow+","+newCol)){
                    queue.add(new int[]{newRow, newCol, curr[2]+1});
                    visited.add(newRow+","+newCol);
                }
            }
        }
        return -1;
    }
}