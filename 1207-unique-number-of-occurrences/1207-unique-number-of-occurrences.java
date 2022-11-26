class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //check for null input 
        if(arr== null)return false;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int num : arr){
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }
        //get a set for occurrences
        HashSet<Integer> hset = new HashSet<>();
        for(int key : hmap.keySet()) {
            if(hset.contains(hmap.get(key))) return false;
            hset.add(hmap.get(key));
        }
        return true;  
    }
}

//Time and space complexity: O(n)