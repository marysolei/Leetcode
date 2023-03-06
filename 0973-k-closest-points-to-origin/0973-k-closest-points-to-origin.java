class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        if(points == null || points.length ==0)return points;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> ((b[1]*b[1] +b[0]*b[0]) - (a[1]*a[1]+ a[0]*a[0] )));
        for(int[] point : points) {
            maxHeap.add(point);
            if(maxHeap.size()>k) maxHeap.poll();
        }
        int[][] result = new int[maxHeap.size()][2];
        int index=0;
        while(!maxHeap.isEmpty()){
            result[index++] = maxHeap.poll();
        }
        return result;
    }
}
//Time Complexity : O(Nlogk) 
//Space Complexity: O(k)