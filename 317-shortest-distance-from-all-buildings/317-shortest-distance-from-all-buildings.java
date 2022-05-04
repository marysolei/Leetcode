class Solution {
    public int shortestDistance(int[][] grid) {
        
        //check for null input 
        if(grid == null || grid.length ==0)return 0;
        int minDistance = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        int totalHouses = 0;
        
        //get the number of total houses
        for(int r=0; r<rows; r++) {
            for(int c=0; c< cols; c++) {
                if(grid[r][c] ==1) totalHouses++;
            }
        }
        //find the min distance sum for each empty cell.
        for(int r=0; r< rows; r++) {
            for(int c=0; c< cols; c++) {
                if(grid[r][c] ==0) minDistance = Math.min(minDistance, bfs(grid, r, c, totalHouses));
            }
        }
        //if we can't reach all houses return -1
        if(minDistance == Integer.MAX_VALUE) return -1;
        return minDistance;
    }
    private int bfs(int[][] grid, int row, int col, int total) {
        
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = grid.length;
        int cols = grid[0].length;
        int distanceSum = 0;
        int housesReached = 0;
        
        // Queue to do a bfs, starting from (row, col) cell.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ row, col });
        
        // Keep track of visited cells.
        boolean[][] vis = new boolean[rows][cols];
        vis[row][col] = true;

        int steps = 0;
        while (!q.isEmpty() && housesReached != total) {
            for (int i = q.size(); i > 0; --i) {
                int[] curr = q.poll();
                row = curr[0];
                col = curr[1];
                
                // If this cell is a house, then add the distance from source to this cell
                // and we go past from this cell.
                if (grid[row][col] == 1) {
                    distanceSum += steps;
                    housesReached++;
                    continue;
                }
                
                // This cell was empty cell, hence traverse the next cells which is not a blockage.
                for (int[] dir : dirs) {
                    int nextRow = row + dir[0]; 
                    int nextCol = col + dir[1];
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                        if (!vis[nextRow][nextCol] && grid[nextRow][nextCol] != 2) {
                            vis[nextRow][nextCol] = true;
                            q.offer(new int[]{ nextRow, nextCol });
                        }
                    }
                }
            }
            
            // After traversing one level of cells, increment the steps by 1 to reach to next level.
            steps++;
        }

        // If we did not reach all houses, then any cell visited also cannot reach all houses.
        // Set all cells visted to 2 so we do not check them again and return MAX_VALUE.
        if (housesReached != total) {
            for (row = 0; row < rows; row++) {
                for (col = 0; col < cols; col++) {
                    if (grid[row][col] == 0 && vis[row][col]) {
                        grid[row][col] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        
        // If we have reached all houses then return the total distance calculated.
        return distanceSum;
    }
}
/*From Leetcode: Our goal is to find the empty land cell with the 
shortest total distance to all houses, so we must first find the shortest 
total distance to all houses from each empty land cell. can be used to 
find the shortest path between a starting cell and any other reachable cell.
For each empty cell (cell value equals 0) in the grid, start a BFS and 
sum all the distances to houses (cell value equals 1) from this cell. We 
will also keep track of the number of houses we have reached from this 
source cell (empty cell). If we cannot reach all the houses from the 
current empty cell, then it is not a valid empty cell. Furthermore, we 
can be certain that any cell visited during this BFS also cannot reach 
all of the houses. So we will mark all cells visited during this BFS as 
obstacles to ensure that we do not start another BFS from this region. 
Algorithm
1- For each empty cell (grid[i][j] equals 0), start a BFS:
    - In the BFS, traverse all 4-directionally adjacent cells that are not blocked or visited and keep track of the distance from the start cell. Each iteration adds 1 to the distance.
    - Every time we reach a house, increment houses reached counter by 1, and increase the total distance by the current distance.
    
    - If housesReached equals totalHouses, then return the total distance.
    - Otherwise, the starting cell (and every cell visited during this BFS) cannot reach all of the houses. So set every visited empty land cell equal to 2 so that we do not start a new BFS from that cell and return INT_MAX.
2- Each time a total distance is returned from a BFS call, update the minimum distance (minDistance).
3 - If it is possible to reach all houses from any empty land cell, then return the minimum distance found. Otherwise, return -1.*/