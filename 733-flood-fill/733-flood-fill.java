class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //check for null input 
        if(image == null || image.length ==0) return image;
        if(image[sr][sc] == newColor)return image;
        
        //get rows and cols
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];
        helper(image, sr, sc, newColor, oldColor);    
        return image;
    }
    public void helper(int[][] image, int row, int col, int newColor, int oldColor){
        //check edge cases
        if(row< 0 || col<0 || row>= image.length || col>= image[row].length || image[row][col] != oldColor)return;
        
        image[row][col] = newColor;
        helper(image, row+1, col, newColor, oldColor);
        helper(image, row-1, col, newColor, oldColor);
        helper(image, row, col+1, newColor, oldColor);
        helper(image, row, col-1, newColor, oldColor);
    }
}