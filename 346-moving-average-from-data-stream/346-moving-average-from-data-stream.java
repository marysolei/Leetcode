class MovingAverage {
    
    int size;
    List<Integer> queue = new ArrayList<>();
    public MovingAverage(int size) {
        this.size = size;    
    }
    
    public double next(int val) {
        
        queue.add(val);
        int currSum = 0; //calculate the curr sum of the window 
    
        for(int i= Math.max(0, queue.size()-size); i< queue.size(); i++) {
            currSum+= queue.get(i);
        }
        //return the value as double
        return currSum*1.0/Math.min(size, queue.size());
    }
}
//Time Compelxity: O(n) where n is the size of the window 
//space compleixty: O(s) where s is the length of the queue 

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */