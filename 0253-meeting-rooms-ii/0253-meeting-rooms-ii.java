class Solution {
    public int minMeetingRooms(int[][] intervals) {
     
        //check for null input 
        if(intervals == null || intervals.length ==0)return 0;
        //sort the array based on start time 
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        //a minheap based on end time 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int[] earliest = intervals[0];
        minHeap.add(intervals[0]);
        //going over the intervals if there is an overlap we need to add it to the heap
        for(int i=1; i< intervals.length ; i++){
            earliest = minHeap.poll();
            int[] curr = intervals[i];
            if(curr[0] >= earliest[1]){
                 //if there is no overlap, update the end time
                earliest[1] = Math.max(earliest[1], curr[1]);
            }else {
                //more meeting room is needed 
                minHeap.add(curr);
            }
            minHeap.add(earliest);
        }
        //return the size of the heap == number of the rooms 
        return minHeap.size();
    }
}
//Time compelxity: O(nlogn) because of sorting and minHeap
//Space complexity: O(n) because we make a minHeap that contains n elements