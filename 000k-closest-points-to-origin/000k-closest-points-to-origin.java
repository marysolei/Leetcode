class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        if(points == null || points.length ==0) return points;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[1]*b[1] +b[0]*b[0]) -(a[1]*a[1]+a[0]*a[0]));
        
        for(int[] point :points){
            maxHeap.add(point);
            if(maxHeap.size()>k) maxHeap.poll();
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            res[i]= maxHeap.poll();
        }
        return res;
    }
}
//Time Complexity : O(Nlogk) 
//Space Complexity: O(k)