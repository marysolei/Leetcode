class Solution {
 public int minimumMoves(int[][] grid) {
        List<int[]> consumers = new ArrayList<>();
        List<int[]> suppliers = new ArrayList<>();
        
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[r][c] == 0)
                    consumers.add(new int[]{r, c});
                else if (grid[r][c] > 1) 
                    suppliers.add(new int[]{r, c, 1});
            }
        }

        return dfs(0, consumers, suppliers, grid);
    }
    private int dfs(int pos, List<int[]> consumers, List<int[]> suppliers, int[][] grid) {
        if (pos == consumers.size()) 
            return 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < suppliers.size(); i++) {
            int[] s = suppliers.get(i);
            if (s[2] == 0) continue;
            grid[s[0]][s[1]]--;
            if (grid[s[0]][s[1]] == 1) {
                s[2] = 0;
            }
            min = Math.min(min, dfs(pos + 1, consumers, suppliers, grid) + getDis(consumers.get(pos), s));
            grid[s[0]][s[1]]++;
            s[2] = 1;
        }
        return min;
    }
    
    private int getDis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

/* Iterate through all possible pairs of source (cell value > 1) and destination cells (cell value == 0) in the grid to check if it's possible to move a stone from the source cell to the destination cell.

Source cell is the cell having value greater than 1
Destination cell is the cell having 0 value

The base case of the recursion is when all cells in the grid contain exactly one stone. In this case, no further moves are needed, and the function returns 0.

For each pair of destination cell (i, j) and source cell (k, l) :

1-Check if the Destination cell is empty (contains 0 stones) and if the Source cell contains more than 1 stone.
2-Decrease the number of stones in the Source cell by 1 and increase the number of stones in the Destination cell by 1.
3-Calculate the Manhattan distance between the Source cell and the Destination cell.
4-Backtracking step: After exploration, restore the original grid configuration, i.e, reverse of step 2.
5-The count variable keeps track of the minimum number of moves needed to achieve the desired configuration. */