class Solution {
    public boolean exist(char[][] board, String word) {
        
        //check for null input 
        if(board == null || board.length ==0)return false;
        int rows = board.length;
        int cols = board[0].length;
        //search in the board to find the word
        for(int row=0; row< rows; row++) {
            for(int col= 0; col< cols ; col++){
                    //if we found the first char
                    if(board[row][col] == word.charAt(0)) {
                        if( helper(board, row, col,word,0)) return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, int row, int col, String word, int index){
        if(index == word.length()) return true;
        //check for edge cases 
        if(row<0 || col<0 || row>= board.length || col>= board[0].length || board[row][col] != word.charAt(index)) return false;
        //mark as visited
        char tmp = board[row][col];
        board[row][col] = '-';
        boolean found =   helper(board, row+1, col,word, index+1)||
        helper(board, row-1, col,word, index+1)||
        helper(board, row, col-1,word, index+1)||
        helper(board, row, col+1,word, index+1);
        board[row][col] = tmp;
        return found;
    }
}