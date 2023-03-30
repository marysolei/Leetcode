class Solution {
    public int[][] merge(int[][] intervals) {
        
        //check for null input 
        if(intervals == null || intervals.length==0)return intervals;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int[] earliest = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(earliest);
        for(int i=1; i< intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0]<= earliest[1]){
                earliest[1] = Math.max(earliest[1], curr[1]);
            }else{
                res.add(curr);
                earliest = curr;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
//time complexity: O(nlogn) for sorting
//space complexity: O(n)