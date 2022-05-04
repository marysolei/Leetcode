class Solution {
     
    int n= 3;
    int[][] board;
    public String tictactoe(int[][] moves) {
        
        board = new int[n][n];
        int player = 1;
        
        for(int[] move : moves){
            int row = move[0];
            int col = move[1];
            board[row][col] = player;
            //any winning condition 
            if(checkRow(row, player) ||
               checkCol(col, player) ||
               (row == col && checkDiagonal(player))||
               (row+col == n-1 && checkAntiDiagonal(player))){
                return player ==1? "A":"B";
            }
            player*= -1;
        }
        
        return moves.length == n*n? "Draw":"Pending";
    }
    //check if there is a winner in a row
    public boolean checkRow(int row , int player) {
        for(int col =0; col<n ; col++) {
            if(board[row][col] != player) return false;
        }
        return true;
    }
    //check if there is a winner in a col
    public boolean checkCol(int col, int player){
        for(int row = 0; row< n; row++){
            if(board[row][col] != player) return false;
        }
        return true;
    }
    //check if there is a winner in a diagonal
    public boolean checkDiagonal (int player){
        for(int row =0; row< n; row++) {
            if(board[row][row] != player) return false;
        }
        return true;
    }
    //check if there is a winner in a anti-diagonal
    public boolean checkAntiDiagonal(int player){
        for(int row = 0; row<n ; row++){
            if(board[row][n-row-1] != player) return false;
        }
        return true;
    }
}

//Time complexity of O(m*n) where m is the length of moves and n is the board length
//space complexity : O(n*n) made a board of size n*n