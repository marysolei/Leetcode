class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0)return result;
        //make a hashmap of keys and their anagrams
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(String str : strs){
            String key = getKey(str);
            if(!hmap.containsKey(key)){
                hmap.put(key, new ArrayList<>());
            } 
            hmap.get(key).add(str);
        }
        for(String key: hmap.keySet()){
            result.add(hmap.get(key));
        }
        return result;
    }
    public String getKey(String str){
        
        char[] tmp = str.toCharArray();
        Arrays.sort(tmp);
        StringBuilder res = new StringBuilder();
        for(char c : tmp){
            res.append(c);
        }
        return res.toString();
    }
}
//Time complexity: O(nklogk)
//space complexity: O(nk)