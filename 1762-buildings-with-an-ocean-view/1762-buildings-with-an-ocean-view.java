class Solution {
    public int[] findBuildings(int[] heights) {
        
        //check for null input 
        if(heights == null || heights.length ==0)return heights;
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=heights.length-1; i>=0; i--){
            //if the building to the right is smaller than the curr then we can remove it from stack
            while(!stack.isEmpty() && heights[stack.peek()] < heights[i]) stack.pop();
            //if the stack is Empty then there is no building to the right to block the view
            if(stack.isEmpty()) res.add(i);
            
            //add curr building to the stack
            stack.push(i);
        }
        //prepare the result
        int[] result = new int[res.size()];
        for(int i=res.size()-1; i>=0; i--) {
            result[result.length-1-i]= res.get(i);
        }
        return result;
    }
}

//Time and space complexity : O(n)