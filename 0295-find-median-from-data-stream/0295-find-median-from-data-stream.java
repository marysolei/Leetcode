class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num) maxHeap.add(num);
        else minHeap.add(num);
        if(Math.abs(maxHeap.size() - minHeap.size()) >1) rebalance (minHeap, maxHeap);
    }
    public void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        
        PriorityQueue<Integer> bigger = maxHeap.size() > minHeap.size()? maxHeap: minHeap;
        PriorityQueue<Integer> smaller = maxHeap.size() > minHeap.size()? minHeap: maxHeap;
        while(bigger.size() -smaller.size()>1){
            smaller.add(bigger.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek()+ maxHeap.peek())/2.0;
        }
        PriorityQueue<Integer> bigger = maxHeap.size() > minHeap.size()? maxHeap: minHeap;
        return bigger.peek()*1.0;
    }
}

// Time complexity: worst case three heap insertion and two heap deletion = O(5logn) = O(logn)
//space complexity: O(n)

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */