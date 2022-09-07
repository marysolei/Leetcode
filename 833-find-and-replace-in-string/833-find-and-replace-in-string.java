class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        if(s.length() == 0 || indices.length ==0)return s;
        
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0; i< indices.length; i++) indexMap.put(indices[i], i);
        Arrays.sort(indices);
        
        StringBuilder res = new StringBuilder();
        int curr = 0;
        ///For each index, check for validity, and append a) substring from last processed till current index, and b) target string
        for(int index : indices){
            int i = indexMap.get(index);
            int next = index + sources[i].length();
            if(s.substring(index, next).equals(sources[i])){
                res.append(s.substring(curr,index));
                res.append(targets[i]);
                curr = next;
            }
        }
        // append the residual substring// 
        res.append(s.substring(curr));
        return res.toString();
    }
}