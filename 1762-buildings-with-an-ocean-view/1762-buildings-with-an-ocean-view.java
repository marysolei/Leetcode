class Solution {
    public int[] findBuildings(int[] heights) {
        
        //check for null input 
        if(heights == null || heights.length ==0)return heights;
        int lastBuilding = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        
        //going through buildings
        for(int i=heights.length-1; i>=0 ; i--){
            //if the current building is taller than the last one
            if(heights[i]> lastBuilding){
                res.add(i);
                lastBuilding = heights[i];
            }
        }
        int[] result = new int[res.size()];
        int index=0;
        for(int i=res.size()-1; i>=0; i--){
            result[index++] =res.get(i);
        }
        return result;
    }
}
//Time and Space complexity of O(n)