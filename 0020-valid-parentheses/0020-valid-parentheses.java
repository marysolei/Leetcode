class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() ==0) return false;
        Stack<Character> parenStack = new Stack<>();
        HashMap<Character, Character> parenMap = new HashMap<>();
        parenMap.put('(',')');
        parenMap.put('{','}');
        parenMap.put('[',']');
        for(char c: s.toCharArray()){
            if(c =='(' || c=='{' || c== '['){
                parenStack.push(parenMap.get(c));
            }else{
                if(parenStack.isEmpty() || parenStack.pop() !=c)
                   return false;
            }
        }
        return parenStack.size() ==0;
    }
}
//Time and space complexity: O(n) where n is the number of chars in s