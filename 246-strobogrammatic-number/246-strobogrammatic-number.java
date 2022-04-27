class Solution {
    public boolean isStrobogrammatic(String num) {
        
        StringBuilder rotated = new StringBuilder();
        //starting from end of the string
        for(int i=num.length() -1; i>= 0; i--){
            char c = num.charAt(i);
            if(c =='0' || c=='1' || c== '8'){
                rotated.append(c);
            }else if(c == '6'){
                rotated.append('9');
            }else if(c=='9'){
                rotated.append('6');
            }else {
                return false; //invalid digit
            }
        }
        return num.equals(rotated.toString());
    }
}