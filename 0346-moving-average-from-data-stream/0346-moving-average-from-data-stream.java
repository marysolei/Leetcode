class MovingAverage {
    int size;
    Queue<Integer> queue;
    double currSum;
    int currSize;
    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<>();
        currSum= 0.0;
        currSize=0;
    }
    
    public double next(int val) {
        int tail=0;
        currSize++;
        queue.add(val);
        if(queue.size()>size) {
            tail = queue.poll();
        }
        currSum += val-tail;
        return currSum/Math.min(currSize, size);
    }
}
//Time Complexity: O(1)
//Space Complexity: O(N), where N is the size of the moving window.

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */