class MovingAverage {
    
    Queue<Integer> queue;
    int size;
    double currSum;
    int currSize;
    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
        currSum= 0.0;
        currSize = 0;
    }
    
    public double next(int val) {
        currSize++;
        queue.add(val);
        if(queue.size()>size){
            currSum -= queue.poll();
        } 
        currSum += val;
        return currSum/Math.min(queue.size(), currSize);
    }
}
//Time Complexity: O(1)
//Space Complexity: O(N), where N is the size of the moving window.

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */