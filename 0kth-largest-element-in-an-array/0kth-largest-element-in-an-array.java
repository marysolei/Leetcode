class Solution {
    public int findKthLargest(int[] nums, int k) {
        //check for null input 
        if(nums == null || nums.length ==0)return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums){
            minHeap.add(num);
            if(minHeap.size()>k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
//time complexity:O(nlogk)
//space complexity: O(k)