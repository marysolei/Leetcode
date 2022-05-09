class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int len = reservedSeats.length; 
        HashMap<Integer, HashSet<Integer>> hmap = new HashMap<>();
        for(int[] seat : reservedSeats) {
            if(!hmap.containsKey(seat[0])) hmap.put(seat[0], new HashSet<>());
            hmap.get(seat[0]).add(seat[1]);
        }
        //Since the map only stores data for rows that have at least one occupied seat, the amount of empty rows will be (n - map.size). The max amount of families you can fit in an empty row is 2.
        int res = (n - hmap.size()) * 2;
        for(int key : hmap.keySet()){
            boolean flag = false;
            HashSet<Integer> reserved = hmap.get(key);
            if(!reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4) && !reserved.contains(5)){
                res++;
                flag = true;
            }
               if(!reserved.contains(6)&& !reserved.contains(7)&& !reserved.contains(8) && !reserved.contains(9)){
                   res++;
                   flag = true;
               }
            if(!flag && !reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6) && !reserved.contains(7)) res++;
        }
        return res;
    }
}