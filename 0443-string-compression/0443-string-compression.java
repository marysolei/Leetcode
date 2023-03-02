class Solution {
    public int compress(char[] chars) {
        
       if(chars == null) return 0;
        int i=0;
        int resIndex=0;
        while(i<chars.length){
            int cnt=0;
            char curr = chars[i];
            while(i<chars.length && curr == chars[i] ){
                i++;
                cnt++;
            }
            chars[resIndex++]= curr;
            if(cnt !=1){
                for(char c: Integer.toString(cnt).toCharArray()){
                    chars[resIndex++] =c;
                }
            }
        }
        return resIndex;
    }
}