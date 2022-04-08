class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result = new ArrayList<>();
        //check for null input
        if(heights == null || heights.length ==0)return result;
        //get rows and cols 
        int rows = heights.length;
        int cols = heights[0].length;
        //get queues for bfs
        Queue<int[]> pacificQ = new ArrayDeque<>();
        Queue<int[]> atlanticQ = new ArrayDeque<>();
        //fill the queues
        for(int r=0; r< rows; r++) {
            pacificQ.add(new int[]{r,0});
            atlanticQ.add(new int[]{r,cols-1});
        }
        for(int c=0; c<cols; c++) {
            pacificQ.add(new int[]{0,c});
            atlanticQ.add(new int[]{rows-1,c});
        }
        //run bfs for each ocean to find overlapped cells
        boolean[][] pacificReach = bfsHelper(pacificQ,rows, cols, heights);
        boolean[][] atlanticReach = bfsHelper(atlanticQ, rows, cols, heights);
        //find the overlaping cells
        for(int r=0; r< rows; r++){
            for(int c=0; c< cols; c++){
                if(pacificReach[r][c] && atlanticReach[r][c]){
                    result.add(List.of(r,c));
                }
            }
        }
        return result;
    }
    public boolean[][] bfsHelper(Queue<int[]> queue, int rows, int cols, int[][] heights) {
        
        boolean[][] result = new boolean[rows][cols];
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            //the cell is reachable so mark it 
            result[curr[0]][curr[1]] = true;
            for(int[] dir: dirs){
                int newX = curr[0]+dir[0];
                int newY = curr[1]+dir[1];
                if(newX>=0 && newY>=0 && newX<rows && newY<cols && result[newX][newY] ==false){
                    if(heights[newX][newY]>= heights[curr[0]][curr[1]]){
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return result;
    }
}
/*from leetcode: let's start at the oceans and try to work our way to the cells. This will be much faster because when we start a traversal at a cell, whatever result we end up with can be applied to only that cell. However, when we start from the ocean and work backwards, we already know that every cell we visit must be connected to the ocean.
If we start traversing from the ocean and flip the condition (check for higher height instead of lower height)
Let's start a BFS traversal from every cell that is immediately beside the Pacific ocean, and figure out what cells can flow into the Pacific. Then, let's do the exact same thing with the Atlantic ocean. At the end, the cells that end up connected to both oceans will be our answer.

Algorithm :
    1.If the input is empty, immediately return an empty array.

    2.Initialize variables that we will use to solve the problem:
        Number of rows and columns in our matrix;
        2 queues, one for the Atlantic Ocean and one for the Pacific Ocean that will be used for BFS;
        2 data structures, again one for each ocean, that we'll use to keep track of cells we already visited, to avoid infinite loops;
        A small array [(0, 1), (1, 0), (-1, 0), (0, -1)] that will help with BFS.

    3.Figure out all the cells that are adjacent to each ocean, and fill the respective data structures with them.

    4.Perform BFS from each ocean. The data structure used to keep track of cells already visited has a double purpose - it also contains every cell that can flow into that ocean.

    5.Find the intersection, that is all cells that can flow into both oceans.
*/