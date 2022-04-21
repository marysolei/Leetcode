class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //check for null input 
        if(nums == null || nums.length ==0)return -1;
        //a minheap to track the order of numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.add(num);
            //we just need k elements in the heap
            if(minHeap.size()>k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
//Time complexity: O(nlogk)
//Space complexity: O(k) store k elements in the heap