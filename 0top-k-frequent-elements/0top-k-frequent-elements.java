class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //check for null input 
        if(nums == null || nums.length==0) return nums;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> freqMap.get(a) - freqMap.get(b));
        for(int key: freqMap.keySet()){
            minHeap.add(key);
            if(minHeap.size()>k)minHeap.poll();
        }
        int[] res = new int[k];
        int index=0;
        while(!minHeap.isEmpty()){
            res[index++] = minHeap.poll();
        }
        return res;
    }
}
//Time complexity : O(Nlogk) if k<N and O(N) in the particular case of N=k. That ensures time complexity to be better than O(NlogN).
// Space complexity : O(N+k) to store the hash map with not more N elements and a heap with k elements. 
