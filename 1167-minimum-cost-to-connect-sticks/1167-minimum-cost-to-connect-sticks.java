class Solution {
    public int connectSticks(int[] sticks) {
        
        if(sticks == null || sticks.length ==0)return 0;
        //make a min-heap of sticks to sort them based on their length 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks) pq.add(stick);
        int res = 0;
        //grab the two smallest sticks and calculate the sum
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            res += x+y;
            pq.add(x+y);
        }
        return res;
    }
}
//Time Complexity: O(nlog(n)) -> reheaphify every single time that we remove an element, and we have n elements => nlog(n)
//Space Complexity: O(n) we have n elements