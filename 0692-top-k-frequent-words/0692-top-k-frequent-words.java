class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> result = new ArrayList<>();
        //check for null input 
        if(words == null || words.length ==0)return result;
        //make a hashmap of each word and its freq
        HashMap<String, Integer> freqMap = new HashMap<>();
        for(String word : words) freqMap.put(word, freqMap.getOrDefault(word,0)+1);
       
        //make a priorityQueue of words based on their freq and lexicographical order
        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b)-> freqMap.get(a) == freqMap.get(b)? b.compareTo(a) : freqMap.get(a) - freqMap.get(b));
        for(String key: freqMap.keySet()) {
            minHeap.add(key);
            if(minHeap.size()>k) minHeap.poll();
        }
        while(!minHeap.isEmpty()) result.add(minHeap.poll());
        Collections.reverse(result);
        return result;
    }
}