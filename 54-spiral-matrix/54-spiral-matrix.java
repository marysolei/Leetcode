class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length ==0)return result;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(top <= bottom && left <= right){
            //go from left to right
            for(int c=left; c<= right; c++){
                result.add(matrix[top][c]);
            }
            top++;
            //go from top to bottom
            for(int r=top; r<= bottom; r++){
                result.add(matrix[r][right]);
            }
            right--;
            //go from right to left
            for(int c=right; c>= left; c--){
                if(top>bottom)continue;
                result.add(matrix[bottom][c]);
            }
            bottom--;
            //go from bottom to top
            for(int r=bottom; r>= top; r--){
                if(left>right)continue;
                result.add(matrix[r][left]);
            }
            left++;
        }
        return result;
    }
}