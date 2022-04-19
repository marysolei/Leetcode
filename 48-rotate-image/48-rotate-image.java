class Solution {
    public void rotate(int[][] matrix) {
        //check for null input 
        if(matrix == null || matrix.length ==0)return;
        int n = matrix.length;
        
        for(int row =0; row< (n+1)/2; row++) {
            for(int col=0; col< n/2 ; col++) {
                 int temp = matrix[n - 1 - col][row];
                matrix[n - 1 - col][row] = matrix[n - 1 - row][n - col - 1];
                matrix[n - 1 - row][n - col - 1] = matrix[col][n - 1 -row];
                matrix[col][n - 1 - row] = matrix[row][col];
                matrix[row][col] = temp;
        }
            
    }
}
}
//Time complexity: O(n*n) as we need to read each cell once
//Space complexity: O(1)