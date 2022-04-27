class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        
        if(maxHeap.isEmpty() || maxHeap.peek()> num) {
            maxHeap.add(num);
        }else minHeap.add(num);
        if(Math.abs(maxHeap.size() - minHeap.size())>1) rebalance (minHeap, maxHeap);
    }
    public void rebalance (PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        //balance the two pqs
        PriorityQueue<Integer> bigger = maxHeap.size()> minHeap.size()? maxHeap : minHeap;
        PriorityQueue<Integer> smaller = maxHeap.size()< minHeap.size()? maxHeap : minHeap;
        while(bigger.size() - smaller.size() >1) {
            smaller.add(bigger.poll());
        }
    }
    
    public double findMedian() {
        //if there is no middle value
        if(maxHeap.size() == minHeap.size()) return (maxHeap.peek()+ minHeap.peek())/2.0;
        //there is a middle value
        PriorityQueue<Integer> bigger = maxHeap.size()> minHeap.size()? maxHeap : minHeap;
        return bigger.peek()*1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */