class Solution {
    public void gameOfLife(int[][] board) {
        
        //check for null input 
        if(board == null || board.length ==0)return;
        int rows = board.length;
        int cols = board[0].length;
        int[][] copyBoard = new int[rows][cols];
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for(int r=0; r< rows; r++){
            for(int c=0; c< cols; c++) {
                copyBoard[r][c] = board[r][c];
            }
        }
        
        for(int r=0; r< rows; r++){
            for(int c=0; c< cols ; c++) {
                int liveNeighbors = 0;
                for(int[] dir : dirs) {
                    int newRow = dir[0]+r;
                    int newCol = dir[1]+c;
                    if(newRow>= 0 && newCol>= 0 && newRow<rows && newCol< cols && copyBoard[newRow][newCol] ==1) liveNeighbors++;
                }
                //case 1 & 3: 
                if(copyBoard[r][c] == 1 && (liveNeighbors <2 || liveNeighbors > 3 )) board[r][c] = 0;
                //case 4:
                if(copyBoard[r][c] == 0 && liveNeighbors == 3)board[r][c] =1;
            }
        }
    }
}

//Time and space complexity of O(r*c)