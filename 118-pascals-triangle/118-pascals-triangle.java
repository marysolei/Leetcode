class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        //check for null input 
        if(numRows == 0)return result;
        
        //base case
        result.add(new ArrayList<>());
        result.get(0).add(1);
        
        for(int i=1; i<numRows; i++){
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = result.get(i-1);
            currRow.add(1);
            for(int j=1; j< i; j++) {
                currRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            currRow.add(1);
            result.add(currRow);
        }
        return result;
    }
}