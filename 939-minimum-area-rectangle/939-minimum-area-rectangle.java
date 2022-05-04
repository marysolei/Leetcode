class Solution {
    public int minAreaRect(int[][] points) {
        
        //check for null input 
        if(points == null || points.length ==0)return 0;
        
        HashMap<Integer, HashSet<Integer>> hmap = new HashMap<>();
        for(int[] point: points) {
            if(!hmap.containsKey(point[0])){
                hmap.put(point[0], new HashSet<>());
            }
            hmap.get(point[0]).add(point[1]);
        }
        int min = Integer.MAX_VALUE;
        for(int[] p1: points) {
            for(int[] p2:points){
                //if they have same x and y
                if(p1[0] == p2[0] || p1[1] ==p2[1]) continue;
                if(hmap.get(p1[0]).contains(p2[1]) && hmap.get(p2[0]).contains(p1[1])){
                    min = Math.min(min, Math.abs(p1[0]-p2[0]) * Math.abs(p1[1]-p2[1]));
                }
            }
        }
        return min==Integer.MAX_VALUE? 0:min;
    }
}

//Time complexity : O(n^2)