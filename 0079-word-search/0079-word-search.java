class Solution {
    public boolean exist(char[][] board, String word) {
        //check for null input
        if(board == null || board.length ==0 || word.length()==0) return false;
        int rows= board.length;
        int cols = board[0].length;
        for(int r=0; r< rows; r++){
            for(int c=0; c< cols;c++){
               if(word.charAt(0) == board[r][c]){
                   if(helper(board, word, r,c,0)) return true;
               }
            }
        }
        return false;
    }
    boolean helper(char[][] board, String word, int r, int c, int index){
        if(index == word.length()) return true;
        if(r<0 || r>= board.length || c<0 || c>= board[0].length || board[r][c] != word.charAt(index)) return false;
        char tmp = board[r][c];
        board[r][c] = '-';
        boolean isFound = helper(board, word, r+1, c, index+1)||
                          helper(board, word, r-1, c, index+1)||
                          helper(board, word, r, c+1, index+1)||
                          helper(board, word, r, c-1, index+1);
        board[r][c] = tmp;
        return isFound;
    }
}