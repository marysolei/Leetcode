class DetectSquares {
    
    List<int[]> coordinates;
    HashMap<String,Integer> hmap;
   
    public DetectSquares() {
        coordinates = new ArrayList<>();
        hmap = new HashMap<>();
    }
    
    public void add(int[] point) {
        coordinates.add(point);
        String key = point[0] + "@" + point[1];
        hmap.put(key, hmap.getOrDefault(key,0) + 1);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int res = 0;
        for(int[] curr : coordinates){
            int x = curr[0];
            int y = curr[1];
            //if they are not diagonal 
            if( x == px || y == py || Math.abs(px-x) != Math.abs(py-y)) continue;
            res += hmap.getOrDefault(x+"@"+py,0) * hmap.getOrDefault(px+"@"+y,0);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
/*Save all coordinates to a list, in the meanwhile count the frequencies of each coordinate in a hashmap
During count method, check if each coordinate form a square diagnol with the query point, if so, use the counts of the other two coordinates of the square to calculate the total
e.g. x, y and px, py formed a diagnol for a square size of |px -x|, now we just need to see the counts of (x, py) and (px, y).*/