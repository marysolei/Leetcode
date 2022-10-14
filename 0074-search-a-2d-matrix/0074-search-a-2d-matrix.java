class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //check for null input 
        if(matrix == null || matrix.length==0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left =0;
        int right = rows*cols-1;
        
        while(left<=right){
            int midIndex = left+(right-left)/2;
            int midValue = matrix[midIndex/cols][midIndex%cols];
            if(midValue == target) return true;
            if(midValue < target) left = midIndex+1; 
            else right = midIndex-1;
        }
        return false;
    }
}
//Time Complexity: O(log(mn)) -> binary search