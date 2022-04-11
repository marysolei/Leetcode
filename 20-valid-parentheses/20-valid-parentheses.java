class Solution {
    public boolean isValid(String s) {
        
        //check for null input 
        if(s== null || s.length() ==0)return true;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hmap = new HashMap<>();
        hmap.put('[',']');
        hmap.put('{','}');
        hmap.put('(',')');
        for(char c : s.toCharArray()){
            if(c =='(' || c=='{' || c=='[') {
                stack.push(hmap.get(c));
            }else {
                if(stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.size()==0;
    }
}

//Time and Space complexity of O(n)