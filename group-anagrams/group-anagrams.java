class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //check for null input 
        if(strs == null || strs.length ==0)return null;
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for(String str : strs){
            String key = getKey(str);    
            if(!anagramMap.containsKey(key)){
                anagramMap.put(key, new ArrayList<String>());
            }
            anagramMap.get(key).add(str);
            }
        for(String key: anagramMap.keySet()){
            res.add(anagramMap.get(key));
        }
        return res;
    }
    public String getKey(String currStr){
        char[] tmp = currStr.toCharArray();
        Arrays.sort(tmp);
        StringBuilder res = new StringBuilder();
        for(char c: tmp)res.append(c);
        return res.toString();
    }
}
//Time complexity: O(nklogk) where n is the length of strs and k is the max len of a string in strs
//Space complexity: O(nk)