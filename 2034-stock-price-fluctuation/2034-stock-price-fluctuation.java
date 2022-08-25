class StockPrice {
    
    int latestTime;
    HashMap<Integer,Integer> timestampMap;
    PriorityQueue<int[]> minHeap;
    PriorityQueue<int[]> maxHeap;
    
    public StockPrice() {
        latestTime = 0;
        timestampMap = new HashMap<>();
        minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
    }
    
    public void update(int timestamp, int price) {
        // Update latestTime to latest timestamp.
        latestTime = Math.max(latestTime, timestamp);
        timestampMap.put(timestamp,price);
        minHeap.add(new int[]{price, timestamp});
        maxHeap.add(new int[]{price, timestamp});
    }
    
    public int current() {
        return timestampMap.get(latestTime);
    }
    
    public int maximum() {
        int[] top = maxHeap.peek();
        while(timestampMap.get(top[1]) != top[0]){
            maxHeap.poll();
            top= maxHeap.peek();
        }
        return top[0];
    }
    
    public int minimum() {
        int[] top = minHeap.peek();
        while(timestampMap.get(top[1]) != top[0]){
            minHeap.poll();
            top = minHeap.peek();
        }
        return top[0];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */