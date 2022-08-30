class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        char[][] rotated = new char[cols][rows];
        for(int r=0; r< rows; r++){
            for(int c=0; c< cols; c++){
                rotated[c][r] = board[r][c];
            }
        }
        return helper(board, word) || helper(rotated,word);
    }
    public boolean helper(char[][] board, String word){
        
        for(char[] row : board){
            String[] boardRow = new String(row).split("#");
            String[] words = new String[]{word, new StringBuilder(word).reverse().toString()} ;

            for(String curr : words){
                for(String rowChars : boardRow){
                    if(curr.length() == rowChars.length()){
                        int index = 0;
                        while(index < rowChars.length() && (rowChars.charAt(index) ==' ' || rowChars.charAt(index) == curr.charAt(index) )) index++;
                        if(index == rowChars.length()) return true;
                    }
                }
            }
        }
        return false;
    }
}