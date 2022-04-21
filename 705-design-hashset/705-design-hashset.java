class MyHashSet {
    
    Bucket[] bucketArray; 
    int hashKey; 
    public MyHashSet() {
        this.hashKey = 769;
        this.bucketArray = new Bucket[this.hashKey];
        for(int i=0; i< this.hashKey; i++) {
            this.bucketArray[i] = new Bucket();
        }
    }
    public int hashFunc(int key){
        return key % this.hashKey;
    }
    
    public void add(int key) {
        int bucketIndex = this.hashFunc(key);
        this.bucketArray[bucketIndex].insert(key);
    }
    
    public void remove(int key) {
        int bucketIndex = this.hashFunc(key);
        this.bucketArray[bucketIndex].delete(key);
    }
    
    public boolean contains(int key) {
        int bucketIndex = this.hashFunc(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}
public class Bucket{
    
    LinkedList<Integer> container; 
    public Bucket(){
        container = new LinkedList<Integer>();
    }
    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if(index == -1)this.container.addFirst(key);
    }
    public void delete(Integer key){
        this.container.remove(key);
    }
    public boolean exists (Integer key){
        int index = this.container.indexOf(key);
        return index != -1;
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
/*From Leetcode: There are two key questions that one should address, in order to implement the HashSet data structure, namely hash function and collision handling.
- hash function: the goal of the hash function is to assign an address to store a given value. Ideally, each unique value should have a unique hash value.
- collision handling: it could happen that multiple values from space A might be mapped to the same value in space B. This is collision. 
strategies to resolve the collisions:
- Separate Chaining: for values with the same hash key, we keep them in a bucket, and each bucket is independent of each other.

- Open Addressing: whenever there is a collision, we keep on probing on the main space until a free slot is found.

- 2-Choice Hashing: we use two hash functions rather than one, and we pick the generated address with fewer collision.

Essentially, the primary storage underneath a HashSet is a continuous memory as Array. Each element in this array corresponds to a bucket that stores the actual values.

Given a value, first we generate a key for the value via the hash function. The generated key serves as the index to locate the bucket.

Once the bucket is located, we then perform the desired operations on the bucket, such as add, remove and contains.*/