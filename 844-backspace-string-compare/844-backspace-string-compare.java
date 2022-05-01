class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        Stack<Character> sStack = stringToStack(S);
        Stack<Character> tStack = stringToStack(T);
        
        while(!sStack.isEmpty()) {
            char c = sStack.pop();
            if (tStack.isEmpty() || c != tStack.pop() ) {
                return false;
            }
        }
        return sStack.isEmpty()&& tStack.isEmpty();
    }
    
    public Stack<Character> stringToStack (String s) {
        
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