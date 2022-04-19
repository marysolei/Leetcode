class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        //check for null input
        if(intervals == null || intervals.length ==0)return 0;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int cnt = 0;
        
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            int[] earliest = intervals[i-1];
            if(curr[0] < earliest[1]){
                curr[1]= Math.min(earliest[1], curr[1]);
                cnt++;
            }
        }
        return cnt;
    }
}
//Time complexity: O(nlogn) because of sorting
//Space complexity: O(1)