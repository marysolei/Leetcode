class KthLargest {
    
    PriorityQueue<Integer> minHeap ;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums)minHeap.add(num);
    }
    
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size()>k) minHeap.poll();
        return minHeap.peek();
    }
}
//Time Complexity: Given N as the length of nums and M as the number of calls to add(), Time complexity: O(N⋅log(N)+M⋅log(k))

//Space Complexity: O(N)

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */