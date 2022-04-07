class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        //check for null input
        if(rooms == null || rooms.size() ==0)return false;
        //a set to keep track of visited rooms
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> keyStack = new Stack<>();
        visited.add(0);
        keyStack.push(0);
        
        while(!keyStack.isEmpty()){
            
            List<Integer> currKeys = rooms.get(keyStack.pop());
            for(int key : currKeys){
                if(!visited.contains(key)) {
                    keyStack.push(key);
                    visited.add(key);
                }               
            }
            
        }
        return visited.size()== rooms.size();
    }
    
}