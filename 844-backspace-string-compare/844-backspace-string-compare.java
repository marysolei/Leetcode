class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        if(s == null || t== null)return s==t;
        Stack<Character> stackS = stackfill(s);
        Stack<Character> stackT = stackfill(t);
        
        while(!stackS.isEmpty()){
            char c = stackS.pop();
            if(stackT.isEmpty() || c != stackT.pop()) return false;
        }
        return stackS.isEmpty() && stackT.isEmpty();
    }
    public Stack<Character> stackfill(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.add(c);
            } else if (c =='#' && !stack.isEmpty()) {
                stack.pop();
            }
            
        }
        return stack;
    }
}