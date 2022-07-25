class Solution {
    public int lastStoneWeight(int[] stones) {
        
        //check for null input 
        if(stones == null || stones.length ==0)return 0;
        //use a priority queue to dynamically sort the stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        //fill in the queue
        for(int stone: stones) maxHeap.add(stone);
        //get the sorted stones from the queue and follow the stash rules
        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x!=y) maxHeap.add(y-x);
        }
        //return the last stone in the maxHeap or 0 otherwise
        return maxHeap.isEmpty()? 0 : maxHeap.poll();
    }
}
//Time Complexity: O(NlogN) sorting
//Space Complexity: O(N) because of maxHeap