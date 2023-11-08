class Solution {
    public int lastStoneWeight(int[] stones) {
        
        //check for null input 
        if(stones == null || stones.length==0)return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones) maxHeap.add(stone);
        
        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(y!= x){
                maxHeap.add(y-x);
            }
        }
        return maxHeap.isEmpty()? 0 : maxHeap.peek();
    }
}
//Time Complexity: O(NlogN) sorting
//Space Complexity: O(N) because of maxHeap