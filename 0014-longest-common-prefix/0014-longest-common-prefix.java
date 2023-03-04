class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length ==0)return "";
        String curr = strs[0];
        int index =0;
        StringBuilder res = new StringBuilder();
        
        for(int i=0; i<curr.length(); i++){
            char c = curr.charAt(i);
            for(int j= 1; j< strs.length; j++){
                if(index>= strs[j].length() || strs[j].charAt(i) != c) return res.toString();
            }
            res.append(c);
            index++;
        }
        return res.toString();
    }
}