class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        //check for null input 
        if(intervals == null || intervals.length ==0)return 0;
        //sort based on starting time
        Arrays.sort(intervals, (a,b) ->a[0]-b[0]);
        int[] earliest = intervals[0];
        //sort based on end time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->a[1]-b[1]);
        minHeap.add(earliest);
        
        for(int i=1; i< intervals.length; i++){
            int[] current = intervals[i];
            earliest = minHeap.poll();
            //if there is no overlap, update the end time
            if(earliest[1]<= current[0]){
                earliest[1] = Math.max(current[1], earliest[1]) ;
            }else {
                //more meeting room is needed
                minHeap.add(current);
            }
            minHeap.add(earliest);
        }
        return minHeap.size();
    }
}
//Time compelxity: O(nlogn) because of sorting and minHeap
//Space complexity: O(n) because we make a minHeap that contains n elements