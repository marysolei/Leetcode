class MyHashMap {
    
    public int size ;
    public List<Bucket> hashTable;
    public MyHashMap() {
        
        this.size = 2069;
        this.hashTable = new ArrayList<Bucket>();
        for(int i=0; i< this.size ; i++){
            this.hashTable.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        
        int hashKey = key%size;
        this.hashTable.get(hashKey).update(key, value);
    }
    
    public int get(int key) {
        int hashKey = key%size;
        return this.hashTable.get(hashKey).get(key);
    }
    
    public void remove(int key) {
        int hashKey = key%size;
        this.hashTable.get(hashKey).remove(key);
    }
}
class Pair<K, V> {
    public K key;
    public V value;
    
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
}
class Bucket{
    public List<Pair<Integer,Integer>> bucket;
    //constructor
    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer,Integer>>();
    }
    //get func 
    public Integer get (Integer key){
        for(Pair<Integer, Integer> curr : this.bucket){
            if(curr.key.equals(key)){
                return curr.value;
            }
        }
        return -1;
    }
    //update func 
    public void update(Integer key, Integer value) {
        
        boolean found = false;
        for(Pair<Integer, Integer> curr : this.bucket){
            if(curr.key.equals(key)){
                curr.value = value;
                found = true;
            }
        }
        if(!found) this.bucket.add(new Pair<Integer, Integer> (key, value));
    }
    //remove func 
    public void remove(Integer key){
        for(Pair<Integer, Integer> curr : this.bucket) {
            if(curr.key.equals(key)){
                this.bucket.remove(curr);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */