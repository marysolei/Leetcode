class Solution {
    public boolean exist(char[][] board, String word) {
        
        //check for null input 
        if(board == null || board.length ==0)return false;
        int rows = board.length;
        int cols = board[0].length;
        for(int r=0; r< rows; r++){
            for(int c=0; c< cols;c++){
                if(board[r][c] == word.charAt(0)){
                    if(helper(board, word, r, c, 0)) return true;
                }
            }
        }
       return false;
    }
    public boolean helper(char[][] board, String word, int row , int col, int index){
        
        if(index == word.length()) return true;
        //check edge cases
        if(row<0 || row>= board.length || col<0 || col>= board[0].length || word.charAt(index) != board[row][col]) return false;
        
        char tmp = board[row][col];
        board[row][col] = '-';
        boolean isFound = helper(board, word, row+1, col, index+1)||
                          helper(board, word, row-1, col, index+1)||
                          helper(board, word, row, col+1, index+1)||
                          helper(board, word, row, col-1, index+1);
        board[row][col] =tmp;
        return isFound;
    }
}