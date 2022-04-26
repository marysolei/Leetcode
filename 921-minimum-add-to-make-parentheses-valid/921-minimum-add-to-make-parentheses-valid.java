class Solution {
    public int minAddToMakeValid(String s) {
        
        //check for null input 
        if(s == null || s.length() ==0)return 0;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c =='(' ){
                stack.push(c);
            }else if(!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }else stack.push(c);
        }
        return stack.size();
    }
}