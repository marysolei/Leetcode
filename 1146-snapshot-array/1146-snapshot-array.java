class SnapshotArray {
    
    List<HashMap<Integer,Integer>> shot;
    HashMap<Integer,Integer> curr;
    
    public SnapshotArray(int length) {
        shot = new ArrayList<>(length);
        curr = new HashMap<>(length);
    }
    //time complexity: O(1)
    
    public void set(int index, int val) {
        curr.put(index, val);
    }
    //time complexity: O(1)
    
    public int snap() {
        shot.add(curr);
        curr = new HashMap<>();
        return shot.size()-1;
    }
     //time complexity: O(1)
    
    public int get(int index, int snap_id) {
        for(int i=snap_id; i>= 0; i--){
            if(shot.get(i).containsKey(index)){
                return shot.get(i).get(index);
            }
        }
        return 0;
    }
    //Time complexity: O(snap_id)
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */