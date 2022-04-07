class Solution {
    public int lastStoneWeight(int[] stones) {
        
        
        //check edge cases
        if (stones == null || stones.length == 0)return 0 ; 
        //use a priority queue to dynamically sort the stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) ->b-a);
        //fill in the queue
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        //get the sorted stones from the queue and follow the stash rules
        while(maxHeap.size()>1) {
            int y= maxHeap.poll();
            int x = maxHeap.poll();
            if (x!=y) {
                maxHeap.add(y-x);
            }
        }
        //return the last stone in the maxHeap
        return maxHeap.isEmpty()? 0: maxHeap.poll();
    }
}

//Time Complexity: O(NlogN) sorting
//Space Complexity: O(N) because of maxHeap