class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums == null || nums.length ==0 || k ==0)return null;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> hmap.get(a) - hmap.get(b));

        for(int num : nums)hmap.put(num, hmap.getOrDefault(num,0)+1);
        for(int key : hmap.keySet()){
            minHeap.add(key);
            if(minHeap.size() > k)minHeap.poll();
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++) res[i] = minHeap.poll();
        return res;
    }
}
//Time complexity : O(Nlogk) if k<N and O(N) in the particular case of N=k. That ensures time complexity to be better than O(NlogN).
// Space complexity : O(N+k) to store the hash map with not more N elements and a heap with k elements. 
