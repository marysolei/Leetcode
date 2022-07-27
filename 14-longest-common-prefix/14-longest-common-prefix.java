class Solution {
    public String longestCommonPrefix(String[] strs) {
         //check edge cases
        if(strs == null || strs.length==0)return "";
        
        //get the first string
        String current = strs[0];
        StringBuilder res = new StringBuilder();
        int index=0;
        //go through the other words looking for common chars
        for (int i=0; i< current.length(); i++) {
            char c = current.charAt(i);
            for (int j=1; j< strs.length; j++) {
                if (index>= strs[j].length() || strs[j].charAt(i) != c ){
                    return res.toString();
                }
            }
            res.append(c);
            index++;
        }
        return res.toString();
    }
}