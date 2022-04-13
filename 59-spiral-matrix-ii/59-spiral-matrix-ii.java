class Solution {
    public int[][] generateMatrix(int n) {
        
        //check for null input 
        if(n ==0)return null;
        int[][] result = new int[n][n];
        int value = 1;
        
       for(int layer = 0; layer<(n+1)/2; layer++){
           //from left to right
           for(int col=layer; col< n-layer ; col++){
               result[layer][col] = value++;
           }
           //from top to bottom
           for(int row = layer+1; row< n-layer; row++){
               result[row][n-layer-1] = value++;
           }
           //from right to left 
           for(int col = layer+1; col<n-layer; col++){
               result[n-layer-1][n-col-1] = value++;
           }
           //from bottom to up 
           for(int row = layer+1; row< n-layer-1; row++){
               result[n-row-1][layer] = value++;
           }
       }
        return result;
    }
}
//Time Complexity: O(n^2)
//Space complexity: O(1) constant extra space 