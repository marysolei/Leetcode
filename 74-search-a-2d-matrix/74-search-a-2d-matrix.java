class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //check for null input 
        if(matrix == null || matrix.length ==0)return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows*cols-1;
        while(left <= right){
            int index = left +(right-left)/2;
            int mid = matrix[index/cols][index%cols];
            if(mid == target) return true; 
            else if(mid < target) left= index+1;
            else right= index-1;
        }
        return false;
    }
}
//Time Complexity: O(log(mn)) -> binary search