class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //check for null input 
        if(nums == null || nums.length ==0) return nums;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num: nums) hmap.put(num, hmap.getOrDefault(num,0)+1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> hmap.get(a)-hmap.get(b));
        for(int key: hmap.keySet()){
            minHeap.add(key);
            if(minHeap.size()>k)minHeap.poll();
        } 
        int[] res = new int[k];
        for(int i=0;i<k; i++){
            res[i] = minHeap.poll();
        }
        return res;
    }
}
//time complexity: O(Nlogk)
//space complexity:O(N+k)