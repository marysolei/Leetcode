class Solution {
    public int[][] transpose(int[][] matrix) {
        
        //check for null input 
        if(matrix == null)return matrix;
        int rows= matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[cols][rows];
        for(int r=0; r<rows; r++){
            for(int c =0 ; c<cols; c++){
                res[c][r] = matrix[r][c];
            }
        }
        return res;
    }
}