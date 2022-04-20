class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        //check for null input 
        if(points == null || points.length ==0)return points;
        //make a max heap with size of k to keep the k closest points 
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) ->(b[0]*b[0]+ b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        for(int[] point : points){
            maxHeap.add(point);
            if(maxHeap.size()>k)maxHeap.poll();
        }
        int[][] result = new int[k][2];
        int i =k-1; 
        while(!maxHeap.isEmpty()){
            result[i] = maxHeap.poll();
            i--;
        }
        return result;
    }
}

//Time Complexity : O(Nlogk) 
//Space Complexity: O(k)