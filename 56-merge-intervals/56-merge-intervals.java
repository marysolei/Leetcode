class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> result = new ArrayList<>();
        //check for null input
        if(intervals == null || intervals.length ==0) return null;
        //sort based on starting time
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);
        int[] earliest = intervals[0];
        result.add(earliest);
        for(int i=1; i< intervals.length; i++) {
            int[] curr = intervals[i];
            if(earliest[1]>=curr[0]){
                earliest[1] = Math.max(earliest[1], curr[1]);
            }else {
                earliest = curr;
                result.add(earliest);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
//Time complexity: O(longn) because we are sorting the array
