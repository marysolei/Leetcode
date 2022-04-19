class LRUCache {
    
    int capacity;
    HashMap<Integer, ListNode> hmap;
    ListNode start = new ListNode(0,0);
    ListNode end = new ListNode(0,0);
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        hmap = new HashMap<>();
        start.next = end;
        end.prev= start;
    }
    
    public int get(int key) {
        if(!hmap.containsKey(key)) return -1;
        ListNode node = hmap.get(key);
        int result = node.value;
        removeEnd(node);
        addStart(node);
        return result;
    }
    
    public void put(int key, int value) {
        
        if(!hmap.containsKey(key)){
            ListNode node = new ListNode(key,value);
            hmap.put(key, node);
            addStart(node);
            if(hmap.size() > capacity) {
                hmap.remove(end.prev.key);
                removeEnd(end.prev);
            }
        }else {
            ListNode node = hmap.get(key);
            node.value = value;
            removeEnd(node);
            addStart(node);
        }
    }
    public void removeEnd(ListNode node){
        node.prev.next= node.next;
        node.next.prev = node.prev;
    }
    public void addStart(ListNode node){
        node.next = start.next;
        node.prev = start;
        start.next = node;
        node.next.prev = node;
    }
    
    //class ListNode
    public class ListNode{
        
        int key; 
        int value;
        ListNode prev;
        ListNode next;
        
        public ListNode(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */