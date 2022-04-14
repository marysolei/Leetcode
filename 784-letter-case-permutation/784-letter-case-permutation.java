class Solution {
    public List<String> letterCasePermutation(String s) {
        
        //check for null input 
        if(s == null || s.length() ==0)return null;
        List<String> result = new ArrayList<>();
        BacktrackHelper(s.toCharArray(), result, "",0);
        return result;
    }
    public void BacktrackHelper(char[] s , List<String> result, String curr, int i){
        
        //if we get to the end of the curr string
        if(i== s.length) {
            result.add(new String(curr));
        }else{
            //if it is a letter
            if(Character.isLetter(s[i])){ 
                s[i] = Character.toUpperCase(s[i]);
                BacktrackHelper(s, result, curr+s[i], i+1); //upper case branch
                s[i] = Character.toLowerCase(s[i]);
                BacktrackHelper(s, result, curr+s[i], i+1); //lower case branch
            } else {
                BacktrackHelper(s, result, curr+s[i], i+1);
            }
        }
    }
}