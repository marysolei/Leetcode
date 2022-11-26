class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
     //check for null input 
        if(intervals == null || intervals.length ==0) return true;
        //sort based on starting time
        Arrays.sort(intervals, (a,b) -> a[0]- b[0]);
        for(int i=1; i< intervals.length ; i++){
            //check for overlap
            if(intervals[i-1][1]> intervals[i][0]) return false;
        }
        return true;
    }
}
//Time complexity: O(nlogn) -> for sorting
//space complexity: O(1)